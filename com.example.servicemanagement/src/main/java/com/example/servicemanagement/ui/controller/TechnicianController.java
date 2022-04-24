package com.example.servicemanagement.ui.controller;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.entity.Technician;
import com.example.servicemanagement.service.BrandService;
import com.example.servicemanagement.service.TechnicianService;
import com.example.servicemanagement.service.dto.BrandDTO;
import com.example.servicemanagement.service.dto.TechnicianDTO;
import com.example.servicemanagement.service.dto.filter.TechnicianFilterDTO;
import com.example.servicemanagement.ui.api.ApiContract;
import com.example.servicemanagement.ui.controller.common.AbstractController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(ApiContract.TECHNICIAN)
public class TechnicianController extends AbstractController<Technician, TechnicianDTO, TechnicianService, UUID> {
    protected TechnicianController(TechnicianService service) {
        super(service);
    }

    @PostMapping("/filterByQueue")
    public TechnicianDTO findOneByTotalQueue(@RequestBody TechnicianFilterDTO filterDTO) throws IOException {
        return service.findOneByTotalQueue(filterDTO);
    }
}
