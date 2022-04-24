package com.example.servicemanagement.service;

import com.example.servicemanagement.entity.ServiceType;
import com.example.servicemanagement.service.common.AbstractEntityService;
import com.example.servicemanagement.service.dto.ServiceTypeDTO;

import java.util.UUID;

public interface ServiceTypeService extends AbstractEntityService<ServiceType, ServiceTypeDTO, UUID> {
}
