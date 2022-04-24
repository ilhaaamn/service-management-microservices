package com.example.servicemanagementcorev2.service.dto;

import com.example.servicemanagementcorev2.util.Identifiable;

import java.util.UUID;

public class BrandDTO implements Identifiable<UUID> {
    private UUID id;
    private String name;
    private String platform;

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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
