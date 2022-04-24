package com.example.servicemanagement.service.impl;

import com.example.servicemanagement.entity.Customer;
import com.example.servicemanagement.service.CustomerService;
import com.example.servicemanagement.service.common.impl.AbstractEntityServiceImpl;
import com.example.servicemanagement.service.dto.CustomerDTO;
import com.example.servicemanagement.service.mapper.CustomerMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl extends AbstractEntityServiceImpl<Customer, CustomerDTO, UUID> implements CustomerService {
    public CustomerServiceImpl(JpaRepository<Customer, UUID> repository, CustomerMapper mapper) {
        super(repository, mapper);
    }
}
