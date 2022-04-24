package com.example.servicemanagement.service;

import com.example.servicemanagement.entity.Technician;
import com.example.servicemanagement.service.common.AbstractEntityService;
import com.example.servicemanagement.service.dto.TechnicianDTO;
import com.example.servicemanagement.service.dto.filter.TechnicianFilterDTO;

import java.io.IOException;
import java.util.UUID;

public interface TechnicianService extends AbstractEntityService<Technician, TechnicianDTO, UUID> {
    TechnicianDTO findOneByTotalQueue(TechnicianFilterDTO filterDTO) throws IOException;
}
