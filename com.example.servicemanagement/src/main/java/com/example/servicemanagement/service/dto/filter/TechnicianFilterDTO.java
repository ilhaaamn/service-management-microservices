package com.example.servicemanagement.service.dto.filter;

import com.example.servicemanagement.service.common.dto.CommonPageableRequestDTO;
import com.example.servicemanagement.service.dto.BrandDTO;
import com.example.servicemanagement.util.Identifiable;

import java.util.UUID;

public class TechnicianFilterDTO extends CommonPageableRequestDTO {
    private String name;
    private BrandDTO specialization;
    private String platform;
    private Integer totalQueue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BrandDTO getSpecialization() {
        return specialization;
    }

    public void setSpecialization(BrandDTO specialization) {
        this.specialization = specialization;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getTotalQueue() {
        return totalQueue;
    }

    public void setTotalQueue(Integer totalQueue) {
        this.totalQueue = totalQueue;
    }
}
