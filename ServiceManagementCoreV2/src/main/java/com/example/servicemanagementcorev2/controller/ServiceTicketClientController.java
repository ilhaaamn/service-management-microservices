package com.example.servicemanagementcorev2.controller;

import com.example.servicemanagementcorev2.model.TransitionRequest;
import com.example.servicemanagementcorev2.service.ServiceTicketService;
import com.example.servicemanagementcorev2.service.dto.ServiceTicketDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ServiceTicketClientController {
    private final ServiceTicketService serviceTicketService;

    public ServiceTicketClientController(ServiceTicketService serviceTicketService) {
        this.serviceTicketService = serviceTicketService;
    }

    @PostMapping("/serviceTicket/addTicket")
    public ServiceTicketDTO addServiceTicket(@RequestBody ServiceTicketDTO serviceTicketDTO) throws IOException {
        return serviceTicketService.addTicket(serviceTicketDTO);
    }

    @PostMapping("/serviceTicket/updateTicket")
    public ServiceTicketDTO updateServiceTicket(@RequestBody ServiceTicketDTO serviceTicketDTO) throws IOException {
        return serviceTicketService.updateTicket(serviceTicketDTO);
    }

    @PostMapping("/serviceTicket/transitionTicket")
    public ServiceTicketDTO transitionTicket(@RequestBody TransitionRequest transitionRequest) throws IOException {
        return serviceTicketService.transitionTicket(transitionRequest);
    }
}
