package com.example.servicemanagement.repository;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, UUID> {
    Technician findTechnicianByName(String name);
}
