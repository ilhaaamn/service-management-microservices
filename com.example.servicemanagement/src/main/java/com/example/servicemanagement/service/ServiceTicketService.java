package com.example.servicemanagement.service;

import com.example.servicemanagement.entity.ServiceTicket;
import com.example.servicemanagement.service.common.AbstractEntityService;
import com.example.servicemanagement.service.dto.ServiceTicketDTO;
import com.example.servicemanagement.service.dto.filter.ServiceTicketFilterDTO;

import java.util.List;
import java.util.UUID;

public interface ServiceTicketService extends AbstractEntityService<ServiceTicket, ServiceTicketDTO, UUID> {
    List<ServiceTicketDTO> getServiceTickets(ServiceTicketFilterDTO serviceTicketFilterDTO);
}
