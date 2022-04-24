package com.example.servicemanagement.entity;

import com.example.servicemanagement.util.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "technician")
public class Technician implements Identifiable<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "technician_id", nullable = false)
    private UUID id;

    @Column(name = "name", length = 100)
    private String name;

    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand specialization;

    @Column(name = "platform", length = 100)
    private String platform;

    @Column(name = "total_queue", nullable = false)
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

    public Brand getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Brand specialization) {
        this.specialization = specialization;
    }
}
