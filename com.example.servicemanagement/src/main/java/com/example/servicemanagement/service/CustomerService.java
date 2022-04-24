package com.example.servicemanagement.service;

import com.example.servicemanagement.entity.Customer;
import com.example.servicemanagement.service.common.AbstractEntityService;
import com.example.servicemanagement.service.dto.CustomerDTO;

import java.util.UUID;

public interface CustomerService extends AbstractEntityService<Customer, CustomerDTO, UUID> {
}
