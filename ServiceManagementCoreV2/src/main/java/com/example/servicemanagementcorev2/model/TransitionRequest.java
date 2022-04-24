package com.example.servicemanagementcorev2.model;

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
