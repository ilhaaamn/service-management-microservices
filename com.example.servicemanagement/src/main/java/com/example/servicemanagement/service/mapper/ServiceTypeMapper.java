package com.example.servicemanagement.service.mapper;

import com.example.servicemanagement.entity.ServiceType;
import com.example.servicemanagement.service.common.CommonMapper;
import com.example.servicemanagement.service.dto.ServiceTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface ServiceTypeMapper extends CommonMapper<ServiceType, ServiceTypeDTO, UUID> {
}
