package com.example.servicemanagement.ui.model;

import com.example.servicemanagement.util.Identifiable;

import java.io.Serializable;
import java.util.UUID;

public class RequestId<ID extends Serializable> {
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
