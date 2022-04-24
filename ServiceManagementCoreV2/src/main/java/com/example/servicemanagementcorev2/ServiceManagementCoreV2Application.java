package com.example.servicemanagementcorev2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceManagementCoreV2Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceManagementCoreV2Application.class, args);
    }

}
