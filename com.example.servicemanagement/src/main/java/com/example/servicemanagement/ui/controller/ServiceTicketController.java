package com.example.servicemanagement.ui.controller;

import com.example.servicemanagement.entity.ServiceTicket;
import com.example.servicemanagement.service.ServiceTicketService;
import com.example.servicemanagement.service.dto.ServiceTicketDTO;
import com.example.servicemanagement.ui.api.ApiContract;
import com.example.servicemanagement.ui.controller.common.AbstractController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiContract.SERVICE_TICKET)
public class ServiceTicketController extends AbstractController<ServiceTicket, ServiceTicketDTO, ServiceTicketService, UUID> {
    protected ServiceTicketController(ServiceTicketService service) {
        super(service);
    }
}
