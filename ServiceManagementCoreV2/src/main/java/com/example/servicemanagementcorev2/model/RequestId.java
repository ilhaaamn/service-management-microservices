package com.example.servicemanagementcorev2.model;

import java.io.Serializable;

public class RequestId<ID extends Serializable> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
