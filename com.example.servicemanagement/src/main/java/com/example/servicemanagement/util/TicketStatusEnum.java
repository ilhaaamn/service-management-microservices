package com.example.servicemanagement.util;

public enum TicketStatusEnum {
    PENDING_QUEUE("Pending Queue"),
    ASSIGNED("Assigned"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String status;

    TicketStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
