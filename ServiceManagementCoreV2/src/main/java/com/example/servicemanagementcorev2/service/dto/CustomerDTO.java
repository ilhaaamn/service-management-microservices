package com.example.servicemanagementcorev2.service.dto;

import com.example.servicemanagementcorev2.util.Identifiable;

import java.util.UUID;

public class CustomerDTO implements Identifiable<UUID> {
    private UUID id;
    private String name;
    private String address;
    private String email;
    private String contactNo;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
