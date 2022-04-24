package com.example.servicemanagement.ui.controller;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.service.BrandService;
import com.example.servicemanagement.service.dto.BrandDTO;
import com.example.servicemanagement.ui.api.ApiContract;
import com.example.servicemanagement.ui.controller.common.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(ApiContract.BRAND)
public class BrandController extends AbstractController<Brand, BrandDTO, BrandService, UUID> {
    protected BrandController(BrandService service) {
        super(service);
    }
}
