package com.example.servicemanagement.repository.common;

import com.example.servicemanagement.service.common.CommonPageableRequest;
import com.example.servicemanagement.util.Identifiable;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.QuerydslJpaPredicateExecutor;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class AbstractEntityRepository<T extends Identifiable<ID>, F extends CommonPageableRequest, ID extends Serializable> extends QuerydslJpaPredicateExecutor<T> {
    protected final JPAQueryFactory queryFactory;
    private final EntityPathBase<T> qClass;
    private final EntityManager entityManager;

    public AbstractEntityRepository(Class<T> entityClass, EntityManager entityManager, CrudMethodMetadata metadata, EntityPathBase<T> qClass) {
        super(JpaEntityInformationSupport.getEntityInformation(entityClass, entityManager), entityManager, SimpleEntityPathResolver.INSTANCE, metadata);
        this.queryFactory = new JPAQueryFactory(entityManager);
        this.qClass = qClass;
        this.entityManager = entityManager;
    }

    public Page<T> filterPageable(F filter, Pageable pageable) {
        JPAQuery<T> query = queryFactory.selectFrom(qClass).where(getFilter(filter));
        JPAQuery<?> countQuery = query.clone(this.entityManager);

        if (pageable.isPaged()) {
            query.offset(pageable.getOffset());
            query.limit((long)pageable.getPageSize());
        }

        List<T> result = query.fetch();
        Objects.requireNonNull(countQuery);
        return PageableExecutionUtils.getPage(result, pageable, countQuery::fetchCount);
    }

    protected BooleanBuilder getFilter(F filter) {
        return new BooleanBuilder();
    }
}
