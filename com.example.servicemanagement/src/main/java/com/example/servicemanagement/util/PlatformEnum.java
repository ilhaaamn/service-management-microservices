package com.example.servicemanagement.util;

public enum PlatformEnum {
    IOS("IOS"),
    ANDROID("ANDROID");

    private final String name;

    PlatformEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
