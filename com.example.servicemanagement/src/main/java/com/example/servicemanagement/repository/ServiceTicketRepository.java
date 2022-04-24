package com.example.servicemanagement.repository;

import com.example.servicemanagement.entity.ServiceTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ServiceTicketRepository extends JpaRepository<ServiceTicket, UUID> {
}
