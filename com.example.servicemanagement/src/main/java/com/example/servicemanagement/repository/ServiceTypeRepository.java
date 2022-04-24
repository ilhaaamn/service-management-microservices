package com.example.servicemanagement.repository;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, UUID> {
    ServiceType findServiceTypeByName(String name);
}
