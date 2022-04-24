package com.example.servicemanagement.ui.controller;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.entity.ServiceType;
import com.example.servicemanagement.service.BrandService;
import com.example.servicemanagement.service.ServiceTypeService;
import com.example.servicemanagement.service.dto.BrandDTO;
import com.example.servicemanagement.service.dto.ServiceTypeDTO;
import com.example.servicemanagement.ui.api.ApiContract;
import com.example.servicemanagement.ui.controller.common.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiContract.SERVICE_TYPE)
public class ServiceTypeController extends AbstractController<ServiceType, ServiceTypeDTO, ServiceTypeService, UUID> {
    protected ServiceTypeController(ServiceTypeService service) {
        super(service);
    }
}
