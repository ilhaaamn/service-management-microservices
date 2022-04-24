package com.example.servicemanagement.service;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.service.common.AbstractEntityService;
import com.example.servicemanagement.service.dto.BrandDTO;

import java.util.UUID;

public interface BrandService extends AbstractEntityService<Brand, BrandDTO, UUID> {
    BrandDTO getByName(String name);
}
