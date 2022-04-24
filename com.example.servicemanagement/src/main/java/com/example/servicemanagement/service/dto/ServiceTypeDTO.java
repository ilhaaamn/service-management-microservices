package com.example.servicemanagement.service.dto;

import com.example.servicemanagement.util.Identifiable;

import java.math.BigDecimal;
import java.util.UUID;

public class ServiceTypeDTO implements Identifiable<UUID> {
    private UUID id;
    private String name;
    private Integer timeRequired;
    private BigDecimal price;

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

    public Integer getTimeRequired() {
        return timeRequired;
    }

    public void setTimeRequired(Integer timeRequired) {
        this.timeRequired = timeRequired;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
