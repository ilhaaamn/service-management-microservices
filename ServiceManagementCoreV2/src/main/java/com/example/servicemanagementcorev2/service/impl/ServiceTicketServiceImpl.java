package com.example.servicemanagementcorev2.service.impl;

import com.example.servicemanagementcorev2.eurekaClient.ServiceManagementClient;
import com.example.servicemanagementcorev2.model.TechnicianFilterDTO;
import com.example.servicemanagementcorev2.service.ServiceTicketService;
import com.example.servicemanagementcorev2.service.dto.ServiceTicketDTO;
import com.example.servicemanagementcorev2.service.dto.TechnicianDTO;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class ServiceTicketServiceImpl implements ServiceTicketService {
    private final ServiceManagementClient serviceManagementClient;

    public ServiceTicketServiceImpl(ServiceManagementClient serviceManagementClient) {
        this.serviceManagementClient = serviceManagementClient;
    }

    @Override
    public ServiceTicketDTO addTicket(ServiceTicketDTO request) throws IOException {
        Integer maxQueueCount = 3;
        TechnicianFilterDTO technicianFilterDTO = new TechnicianFilterDTO();
        technicianFilterDTO.setPlatform(request.getBrand().getPlatform());
        technicianFilterDTO.setTotalQueue(maxQueueCount);
        TechnicianDTO technicianDTO = null;
        while (Objects.isNull(technicianDTO)) {
            try {
                technicianDTO = serviceManagementClient.filterByQueue(technicianFilterDTO);
            } catch (FeignException e) {
                //LOGGING
            }
            maxQueueCount++;
        }
        request.setTechnician(technicianDTO);
        ServiceTicketDTO serviceTicketDTO = serviceManagementClient.addServiceTicket(request);
        technicianDTO.setTotalQueue(technicianDTO.getTotalQueue() + 1);
        serviceManagementClient.updateTechnician(technicianDTO);
        return serviceTicketDTO;
    }

    //Update ticket
    @Override
    public ServiceTicketDTO updateTicket(ServiceTicketDTO request) throws IOException {
        return serviceManagementClient.updateServiceTicket(request);
    }

    //TODO: ADD IMPLEMENTATION FOR EACH CRUD OPERATIONS (BRAND, CUSTOMER, TECHNICIAN, SERVICE_TYPE)
}
