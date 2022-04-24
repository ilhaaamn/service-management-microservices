package com.example.servicemanagement.service.common;

import com.example.servicemanagement.util.Identifiable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface AbstractEntityService<T extends Identifiable<ID>, D extends Identifiable<ID>, ID extends Serializable> {
    Page<D> findAll(@NotNull Pageable var1);

    List<D> findAll();

    Optional<D> findOne(@NotNull ID var1);

    D save(@NotNull D var1);

    List<D> saveAll(@NotNull List<D> var1);

    D update(@NotNull D var1);

    void delete(@NotNull D var1);

    void delete(@NotNull ID var1);
}