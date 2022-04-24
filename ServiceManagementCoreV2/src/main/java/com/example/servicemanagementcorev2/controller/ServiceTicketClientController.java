package com.example.servicemanagementcorev2.controller;

import com.example.servicemanagementcorev2.model.RequestId;
import com.example.servicemanagementcorev2.model.TransitionRequest;
import com.example.servicemanagementcorev2.service.ServiceTicketService;
import com.example.servicemanagementcorev2.service.dto.ServiceTicketDTO;
import com.example.servicemanagementcorev2.util.TicketStatusEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

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

    @PostMapping("/transition/assigned")
    public ServiceTicketDTO transitionToAssigned(@RequestBody RequestId<UUID> request) throws IOException {
        TransitionRequest transitionRequest = new TransitionRequest();
        transitionRequest.setId(request.getId());
        transitionRequest.setTransitionName(TicketStatusEnum.ASSIGNED.getStatus());
        return serviceTicketService.transitionTicket(transitionRequest);
    }

    @PostMapping("/transition/inprogress")
    public ServiceTicketDTO transitionToInProgress(@RequestBody RequestId<UUID> request) throws IOException {
        TransitionRequest transitionRequest = new TransitionRequest();
        transitionRequest.setId(request.getId());
        transitionRequest.setTransitionName(TicketStatusEnum.IN_PROGRESS.getStatus());
        return serviceTicketService.transitionTicket(transitionRequest);
    }

    @PostMapping("/transition/completed")
    public ServiceTicketDTO transitionToCompleted(@RequestBody RequestId<UUID> request) throws IOException {
        TransitionRequest transitionRequest = new TransitionRequest();
        transitionRequest.setId(request.getId());
        transitionRequest.setTransitionName(TicketStatusEnum.COMPLETED.getStatus());
        return serviceTicketService.transitionTicket(transitionRequest);
    }
}
