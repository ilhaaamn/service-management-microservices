package com.example.servicemanagement.service.dto;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.entity.Customer;
import com.example.servicemanagement.entity.ServiceType;
import com.example.servicemanagement.entity.Technician;
import com.example.servicemanagement.util.Identifiable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;
public class ServiceTicketDTO implements Identifiable<UUID> {
    private UUID id;
    private ServiceTypeDTO serviceType;
    private TechnicianDTO technician;
    private CustomerDTO customer;
    private BrandDTO brand;

    @Column(name = "status", nullable = false)
    private String status;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public ServiceTypeDTO getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceTypeDTO serviceType) {
        this.serviceType = serviceType;
    }

    public TechnicianDTO getTechnician() {
        return technician;
    }

    public void setTechnician(TechnicianDTO technician) {
        this.technician = technician;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
