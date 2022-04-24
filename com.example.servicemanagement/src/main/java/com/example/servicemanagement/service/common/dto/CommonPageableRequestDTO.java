package com.example.servicemanagement.service.common.dto;

import com.example.servicemanagement.service.common.CommonPageableRequest;

public class CommonPageableRequestDTO implements CommonPageableRequest {
    protected Integer page = 1;
    protected Integer pageSize = 20;
    protected String sortBy;
    protected Boolean sortAscFlag;

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public String getSortBy() {
        return sortBy;
    }

    @Override
    public Boolean isSortAsc() {
        return sortAscFlag;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Boolean getSortAscFlag() {
        return sortAscFlag;
    }

    public void setSortAscFlag(Boolean sortAscFlag) {
        this.sortAscFlag = sortAscFlag;
    }
}
