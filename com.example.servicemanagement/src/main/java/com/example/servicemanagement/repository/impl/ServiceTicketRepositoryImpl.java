package com.example.servicemanagement.repository.impl;

import com.example.servicemanagement.entity.QServiceTicket;
import com.example.servicemanagement.entity.ServiceTicket;
import com.example.servicemanagement.repository.common.AbstractEntityRepository;
import com.example.servicemanagement.service.dto.filter.ServiceTicketFilterDTO;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class ServiceTicketRepositoryImpl extends AbstractEntityRepository<ServiceTicket, ServiceTicketFilterDTO, UUID> {
    private static final QServiceTicket qServiceTicket = QServiceTicket.serviceTicket;
    private final EntityManager entityManager;
    public ServiceTicketRepositoryImpl(EntityManager entityManager,
                                       @Nullable CrudMethodMetadata metadata) {
        super(ServiceTicket.class, entityManager, metadata, qServiceTicket);
        this.entityManager = entityManager;
    }

    @Override
    protected BooleanBuilder getFilter(ServiceTicketFilterDTO filter) {
        return new BooleanBuilder()
                .and(qServiceTicket.serviceType.id.eq(filter.getServiceTypeId()))
                .and(qServiceTicket.brand.id.eq(filter.getBrandId()))
                .and(qServiceTicket.technician.id.eq(filter.getTechnicianId()))
                .and(qServiceTicket.status.eq(filter.getStatus()));
    }
}
