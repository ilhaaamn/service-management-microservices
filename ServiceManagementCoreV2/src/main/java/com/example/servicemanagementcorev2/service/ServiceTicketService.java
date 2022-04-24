package com.example.servicemanagementcorev2.service;

import com.example.servicemanagementcorev2.service.dto.ServiceTicketDTO;

import java.io.IOException;

public interface ServiceTicketService {
    //TODO: implement add ticket method
    ServiceTicketDTO addTicket(ServiceTicketDTO request) throws IOException;

    //Update ticket
    ServiceTicketDTO updateTicket(ServiceTicketDTO request) throws IOException;
}
