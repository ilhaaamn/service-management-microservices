package com.example.servicemanagement.service.common.impl;

import com.example.servicemanagement.service.common.AbstractEntityService;
import com.example.servicemanagement.service.common.CommonMapper;
import com.example.servicemanagement.util.Identifiable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AbstractEntityServiceImpl<T extends Identifiable<ID>, D extends Identifiable<ID>, ID extends Serializable> implements AbstractEntityService<T, D, ID> {
    protected JpaRepository<T, ID> repository;
    protected CommonMapper<T, D, ID> mapper;

    public AbstractEntityServiceImpl(JpaRepository<T, ID> repository, CommonMapper<T, D, ID> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(
            readOnly = true
    )
    public Page<D> findAll(Pageable pageable) {
        Page<T> response = this.repository.findAll(pageable);
        CommonMapper<T, D, ID> mapper = this.mapper;
        Objects.requireNonNull(mapper);
        return response.map(mapper::toDto);
    }

    @Override
    @Transactional(
            readOnly = true
    )
    public List<D> findAll() {
        Stream<T> response = this.repository.findAll().stream();
        CommonMapper<T, D, ID> mapper = this.mapper;
        Objects.requireNonNull(mapper);
        return response.map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<D> findOne(ID id) {
        Optional<T> response = repository.findById(id);
        CommonMapper<T, D, ID> mapper = this.mapper;
        Objects.requireNonNull(mapper);
        return response.map(mapper::toDto);
    }

    @Override
    @Transactional
    public D save(@NotNull D dto) {
        T entity = this.mapper.toEntity(dto);
        entity = this.repository.saveAndFlush(entity);
        return this.mapper.toDto(entity);
    }

    @Override
    @Transactional
    public List<D> saveAll(@NotNull List<D> dtos) {
        List<T> entities = this.mapper.toEntity(dtos);
        entities = this.repository.saveAll(entities);
        this.repository.flush();
        return this.mapper.toDto(entities);
    }

    @Override
    @Transactional
    public D update(@NotNull D dto) {
        return this.repository.findById(dto.getId()).map((entity) -> {
            entity = this.mapper.toEntity(dto);
            entity = this.repository.saveAndFlush(entity);
            return this.mapper.toDto(entity);
        }).orElseThrow(() -> {
            return new EntityNotFoundException("Entity not found with id: " + ((Serializable)dto.getId()).toString());
        });
    }

    @Override
    @Transactional
    public void delete(@NotNull D var1) {
        this.repository.deleteById(var1.getId());
    }

    @Override
    @Transactional
    public void delete(ID var1) {
        this.repository.deleteById(var1);
    }
}
