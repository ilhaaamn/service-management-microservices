package com.example.servicemanagementcorev2.service.dto;

import com.example.servicemanagementcorev2.util.Identifiable;

import java.util.UUID;

public class ServiceTicketDTO implements Identifiable<UUID> {
    private UUID id;
    private ServiceTypeDTO serviceType;
    private TechnicianDTO technician;
    private CustomerDTO customer;
    private BrandDTO brand;

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
