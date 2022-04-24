package com.example.servicemanagement.service.common;

public interface CommonPageableRequest {
    Integer getPage() ;
    Integer getPageSize();
    String getSortBy();
    Boolean isSortAsc();
}
