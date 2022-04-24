package com.example.servicemanagement.repository;

import com.example.servicemanagement.entity.Technician;
import com.example.servicemanagement.service.dto.filter.TechnicianFilterDTO;

public interface TechnicianCustomRepository {
    Technician findOneByTotalQueue(TechnicianFilterDTO filterDTO);
}
