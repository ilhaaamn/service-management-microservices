package com.example.servicemanagement.service.common;

import com.example.servicemanagement.util.Identifiable;

import java.io.Serializable;
import java.util.List;

public interface CommonMapper<T  extends Identifiable<ID>, D extends Identifiable<ID>, ID extends Serializable> {
    D toDto(T var1);

    List<D> toDto(List<T> var1);

    T toEntity(D var1);

    default T toEntity(D dto, String... ignoreProperties) {
        return this.toEntity(dto);
    }

    List<T> toEntity(List<D> var1);

    default List<T> toEntity(List<D> dtos, String... ignoreProperties) {
        return this.toEntity(dtos);
    }
}
