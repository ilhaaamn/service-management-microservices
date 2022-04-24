package com.example.servicemanagement.service.impl;

import com.example.servicemanagement.entity.ServiceType;
import com.example.servicemanagement.service.ServiceTypeService;
import com.example.servicemanagement.service.common.impl.AbstractEntityServiceImpl;
import com.example.servicemanagement.service.dto.ServiceTypeDTO;
import com.example.servicemanagement.service.mapper.ServiceTypeMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ServiceTypeServiceImpl extends AbstractEntityServiceImpl<ServiceType, ServiceTypeDTO, UUID> implements ServiceTypeService {
    public ServiceTypeServiceImpl(JpaRepository<ServiceType, UUID> repository, ServiceTypeMapper mapper) {
        super(repository, mapper);
    }
}
