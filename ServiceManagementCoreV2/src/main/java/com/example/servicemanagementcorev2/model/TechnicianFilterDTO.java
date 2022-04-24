package com.example.servicemanagementcorev2.model;

import com.example.servicemanagementcorev2.service.dto.BrandDTO;

public class TechnicianFilterDTO  {
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
