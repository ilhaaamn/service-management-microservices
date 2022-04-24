package com.example.servicemanagement.entity;

import com.example.servicemanagement.util.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "service_type")
public class ServiceType implements Identifiable<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_type_id", nullable = false)
    private UUID id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "time_required")
    private Integer timeRequired;

    @Column(name = "price")
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

    public void setTimeRequired(Integer minuteRequired) {
        this.timeRequired = minuteRequired;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
