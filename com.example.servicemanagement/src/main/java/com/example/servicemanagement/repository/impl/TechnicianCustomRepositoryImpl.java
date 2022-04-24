package com.example.servicemanagement.repository.impl;

import com.example.servicemanagement.entity.QTechnician;
import com.example.servicemanagement.entity.ServiceTicket;
import com.example.servicemanagement.entity.Technician;
import com.example.servicemanagement.repository.TechnicianCustomRepository;
import com.example.servicemanagement.repository.common.AbstractEntityRepository;
import com.example.servicemanagement.service.dto.TechnicianDTO;
import com.example.servicemanagement.service.dto.filter.TechnicianFilterDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class TechnicianCustomRepositoryImpl extends AbstractEntityRepository<Technician, TechnicianFilterDTO, UUID> implements TechnicianCustomRepository {
    private final static QTechnician qTechnician = QTechnician.technician;
    private final EntityManager entityManager;

    public TechnicianCustomRepositoryImpl(EntityManager entityManager,
                                          @Nullable CrudMethodMetadata metadata) {
        super(Technician.class, entityManager, metadata, qTechnician);
        this.entityManager = entityManager;
    }

    @Override
    public Technician findOneByTotalQueue(TechnicianFilterDTO filterDTO) {
        BooleanBuilder booleanBuilder = new BooleanBuilder()
                .and(qTechnician.totalQueue.loe(filterDTO.getTotalQueue()))
                .and(qTechnician.platform.eq(filterDTO.getPlatform()));
        return queryFactory.selectFrom(qTechnician)
                .where(booleanBuilder)
                .orderBy(qTechnician.totalQueue.asc())
                .fetchFirst();
    }
}
