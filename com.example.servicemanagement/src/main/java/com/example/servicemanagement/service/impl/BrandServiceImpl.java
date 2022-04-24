package com.example.servicemanagement.service.impl;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.repository.BrandRepository;
import com.example.servicemanagement.service.BrandService;
import com.example.servicemanagement.service.common.impl.AbstractEntityServiceImpl;
import com.example.servicemanagement.service.dto.BrandDTO;
import com.example.servicemanagement.service.mapper.BrandMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BrandServiceImpl extends AbstractEntityServiceImpl<Brand, BrandDTO, UUID> implements BrandService  {
    //get by name
    private final BrandRepository brandRepository;

    public BrandServiceImpl(JpaRepository<Brand, UUID> repository, BrandMapper mapper, BrandRepository brandRepository) {
        super(repository, mapper);
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandDTO getByName(String name) {
        return mapper.toDto(brandRepository.findBrandByName(name));
    }
}
