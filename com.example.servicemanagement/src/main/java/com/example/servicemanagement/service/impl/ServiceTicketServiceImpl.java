package com.example.servicemanagement.service.impl;

import com.example.servicemanagement.entity.ServiceTicket;
import com.example.servicemanagement.service.BrandService;
import com.example.servicemanagement.service.CustomerService;
import com.example.servicemanagement.service.ServiceTicketService;
import com.example.servicemanagement.service.ServiceTypeService;
import com.example.servicemanagement.service.TechnicianService;
import com.example.servicemanagement.service.common.impl.AbstractEntityServiceImpl;
import com.example.servicemanagement.service.dto.CustomerDTO;
import com.example.servicemanagement.service.dto.ServiceTicketDTO;
import com.example.servicemanagement.service.dto.filter.ServiceTicketFilterDTO;
import com.example.servicemanagement.service.mapper.ServiceTicketMapper;
import com.example.servicemanagement.ui.model.TransitionRequest;
import com.example.servicemanagement.util.TicketStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ServiceTicketServiceImpl extends AbstractEntityServiceImpl<ServiceTicket, ServiceTicketDTO, UUID> implements ServiceTicketService {
    private final ServiceTicketMapper mapper;
    private final TechnicianService technicianService;
    private final CustomerService customerService;
    private final BrandService brandService;
    private final ServiceTypeService serviceTypeService;

    public ServiceTicketServiceImpl(JpaRepository<ServiceTicket, UUID> repository, ServiceTicketMapper mapper, TechnicianService technicianService, CustomerService customerService, BrandService brandService, ServiceTypeService serviceTypeService) {
        super(repository, mapper);
        this.mapper = mapper;
        this.technicianService = technicianService;
        this.customerService = customerService;
        this.brandService = brandService;
        this.serviceTypeService = serviceTypeService;
    }

    @Override
    public List<ServiceTicketDTO> getServiceTickets(ServiceTicketFilterDTO serviceTicketFilterDTO) {
        Pageable pageableRequest = PageRequest.of(serviceTicketFilterDTO.getPage(), serviceTicketFilterDTO.getPageSize());

        Page<ServiceTicket> serviceTicketPage = repository.findAll(pageableRequest);
        return null;
    }

    @Override
    @Transactional
    public ServiceTicketDTO save(ServiceTicketDTO serviceTicketDTO) {
        validateMainData(serviceTicketDTO);
        serviceTicketDTO.setCustomer(validateCustomer(serviceTicketDTO));
        return super.save(serviceTicketDTO);
    }

    @Override
    public ServiceTicketDTO update(ServiceTicketDTO dto) {
        dto.setTechnician(technicianService.findOne(dto.getTechnician().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Technician not found with id: "
                                + dto.getTechnician().getId())));
        return super.update(dto);
    }

    @Override
    public ServiceTicketDTO transition(TransitionRequest transitionRequest) {
        ServiceTicketDTO serviceTicketDTO = findOne(transitionRequest.getId()).orElseThrow(() ->
                new EntityNotFoundException("ServiceTicket not found with id: " + transitionRequest.getId())
        );
        validateTransition(transitionRequest, serviceTicketDTO);
        serviceTicketDTO.setStatus(transitionRequest.getTransitionName());
        return super.update(serviceTicketDTO);
    }

    private void validateTransition(TransitionRequest transitionRequest, ServiceTicketDTO serviceTicketDTO) {
        if (serviceTicketDTO.getStatus().equals(TicketStatusEnum.PENDING_QUEUE.name()) && !transitionRequest.getTransitionName().equals(TicketStatusEnum.ASSIGNED.name())) {
            throw new IllegalArgumentException("ServiceTicket can't be in PENDING_QUEUE status and transition to " + transitionRequest.getTransitionName());
        } else if (serviceTicketDTO.getStatus().equals(TicketStatusEnum.ASSIGNED.name()) && !transitionRequest.getTransitionName().equals(TicketStatusEnum.IN_PROGRESS.name())) {
            throw new IllegalArgumentException("ServiceTicket can't be in ASSIGNED status and transition to " + transitionRequest.getTransitionName());
        } else if (serviceTicketDTO.getStatus().equals(TicketStatusEnum.IN_PROGRESS.name()) && !transitionRequest.getTransitionName().equals(TicketStatusEnum.COMPLETED.name())) {
            throw new IllegalArgumentException("ServiceTicket can't be in IN_PROGRESS status and transition to " + transitionRequest.getTransitionName());
        }
    }

    private void validateMainData(ServiceTicketDTO serviceTicketRequest) {
        technicianService.findOne(serviceTicketRequest.getTechnician().getId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Technician not found with id: "
                                + serviceTicketRequest.getTechnician().getId()));
        brandService.findOne(serviceTicketRequest.getBrand().getId()).orElseThrow(() ->
                new EntityNotFoundException("Brand not found with id: "
                        + serviceTicketRequest.getBrand().getId()));
        serviceTypeService.findOne(serviceTicketRequest.getServiceType().getId()).orElseThrow(() ->
                new EntityNotFoundException("Service type not found with id: "
                        + serviceTicketRequest.getServiceType().getId())
        );
    }

    private CustomerDTO validateCustomer(ServiceTicketDTO serviceTicketDTO) {
        CustomerDTO customerDTO;
        if (Objects.nonNull(serviceTicketDTO.getCustomer().getId())) {
            customerDTO = customerService.findOne(serviceTicketDTO.getCustomer().getId()).orElseThrow(() ->
                    new EntityNotFoundException("Customer not found with id: "
                            + serviceTicketDTO.getCustomer().getId()));
        } else {
            customerDTO = customerService.save(serviceTicketDTO.getCustomer());
        }
        return customerDTO;
    }
}
