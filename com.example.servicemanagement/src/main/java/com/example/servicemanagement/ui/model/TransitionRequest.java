package com.example.servicemanagement.ui.model;

import java.io.Serializable;
import java.util.UUID;

public class TransitionRequest {
    private UUID id;
    private String transitionName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTransitionName() {
        return transitionName;
    }

    public void setTransitionName(String transitionName) {
        this.transitionName = transitionName;
    }
}
