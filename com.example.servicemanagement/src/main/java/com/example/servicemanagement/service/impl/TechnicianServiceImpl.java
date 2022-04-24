package com.example.servicemanagement.service.impl;

import com.example.servicemanagement.entity.Technician;
import com.example.servicemanagement.repository.TechnicianCustomRepository;
import com.example.servicemanagement.service.TechnicianService;
import com.example.servicemanagement.service.common.impl.AbstractEntityServiceImpl;
import com.example.servicemanagement.service.dto.TechnicianDTO;
import com.example.servicemanagement.service.dto.filter.TechnicianFilterDTO;
import com.example.servicemanagement.service.mapper.TechnicianMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class TechnicianServiceImpl extends AbstractEntityServiceImpl<Technician, TechnicianDTO, UUID> implements TechnicianService {
    private final TechnicianCustomRepository technicianCustomRepository;
    public TechnicianServiceImpl(JpaRepository<Technician, UUID> repository, TechnicianMapper mapper, TechnicianCustomRepository technicianCustomRepository) {
        super(repository, mapper);
        this.technicianCustomRepository = technicianCustomRepository;
    }

    @Override
    public TechnicianDTO findOneByTotalQueue(TechnicianFilterDTO filterDTO) throws IOException {
        Technician technician = technicianCustomRepository.findOneByTotalQueue(filterDTO);
        if (Objects.isNull(technician)) {
            throw new IOException("Technician not found");
        }
        return mapper.toDto(technician);
    }
}
