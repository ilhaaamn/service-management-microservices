package com.example.servicemanagement.repository;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Customer findCustomerByName(String name);
}
