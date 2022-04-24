package com.example.servicemanagement.service.dto;

import com.example.servicemanagement.util.Identifiable;

import java.util.UUID;

public class TechnicianDTO implements Identifiable<UUID> {
    private UUID id;
    private String name;
    private BrandDTO specialization;
    private String platform;
    private Integer totalQueue;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

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
