package com.example.servicemanagementcorev2.eurekaClient;

import com.example.servicemanagementcorev2.controller.ApiContract;
import com.example.servicemanagementcorev2.model.RequestId;
import com.example.servicemanagementcorev2.model.TechnicianFilterDTO;
import com.example.servicemanagementcorev2.service.dto.BrandDTO;
import com.example.servicemanagementcorev2.service.dto.CustomerDTO;
import com.example.servicemanagementcorev2.service.dto.ServiceTicketDTO;
import com.example.servicemanagementcorev2.service.dto.ServiceTypeDTO;
import com.example.servicemanagementcorev2.service.dto.TechnicianDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@FeignClient(value = "service-ticket-management", url = "http://localhost:8090")
public interface ServiceManagementClient {

    //BRAND
    @GetMapping(ApiContract.BRAND + "/getAll")
    List<BrandDTO> getAllBrand() throws IOException;

    @PostMapping(ApiContract.BRAND + "/getById")
    BrandDTO getBrandById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.BRAND + "/add")
    BrandDTO addBrand(@RequestBody BrandDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.BRAND + "/delete")
    void deleteBrand(@RequestBody BrandDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.BRAND + "/deleteById")
    void deleteBrandById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.BRAND + "/update")
    BrandDTO updateBrand(@RequestBody BrandDTO brandDTO) throws IOException;

    //CUSTOMER
    @GetMapping(ApiContract.CUSTOMER + "/getAll")
    List<CustomerDTO> getAllCustomer() throws IOException;

    @PostMapping(ApiContract.CUSTOMER + "/getById")
    CustomerDTO getCustomerById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.CUSTOMER + "/add")
    CustomerDTO addCustomer(@RequestBody CustomerDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.CUSTOMER + "/delete")
    void deleteCustomer(@RequestBody CustomerDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.CUSTOMER + "/deleteById")
    void deleteCustomerById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.CUSTOMER + "/update")
    CustomerDTO updateCustomer(@RequestBody CustomerDTO brandDTO) throws IOException;

    //SERVICE TICKET
    @GetMapping(ApiContract.SERVICE_TICKET + "/getAll")
    List<ServiceTicketDTO> getAllServiceTicket() throws IOException;

    @PostMapping(ApiContract.SERVICE_TICKET + "/getById")
    ServiceTicketDTO getServiceTicketById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.SERVICE_TICKET + "/add")
    ServiceTicketDTO addServiceTicket(@RequestBody ServiceTicketDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.SERVICE_TICKET + "/delete")
    void deleteServiceTicket(@RequestBody ServiceTicketDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.SERVICE_TICKET + "/deleteById")
    void deleteServiceTicketById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.SERVICE_TICKET + "/update")
    ServiceTicketDTO updateServiceTicket(@RequestBody ServiceTicketDTO brandDTO) throws IOException;

    //SERVICE TYPE
    @GetMapping(ApiContract.SERVICE_TYPE + "/getAll")
    List<ServiceTypeDTO> getAllServiceType() throws IOException;

    @PostMapping(ApiContract.SERVICE_TYPE + "/getById")
    ServiceTypeDTO getServiceTypeById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.SERVICE_TYPE + "/add")
    ServiceTypeDTO addServiceType(@RequestBody ServiceTypeDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.SERVICE_TYPE + "/delete")
    void deleteServiceType(@RequestBody ServiceTypeDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.SERVICE_TYPE + "/deleteById")
    void deleteServiceTypeById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.SERVICE_TYPE + "/update")
    ServiceTypeDTO updateServiceType(@RequestBody ServiceTypeDTO brandDTO) throws IOException;

    //TECHNICIAN
    @GetMapping(ApiContract.TECHNICIAN + "/getAll")
    List<TechnicianDTO> getAllTechnician() throws IOException;

    @PostMapping(ApiContract.TECHNICIAN + "/getById")
    TechnicianDTO getTechnicianById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.TECHNICIAN + "/add")
    TechnicianDTO addTechnician(@RequestBody TechnicianDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.TECHNICIAN + "/delete")
    void deleteTechnician(@RequestBody TechnicianDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.TECHNICIAN + "/deleteById")
    void deleteTechnicianById(@RequestBody RequestId<UUID> requestId) throws IOException;

    @PostMapping(ApiContract.TECHNICIAN + "/update")
    TechnicianDTO updateTechnician(@RequestBody TechnicianDTO brandDTO) throws IOException;

    @PostMapping(ApiContract.TECHNICIAN + "/filterByQueue")
    TechnicianDTO filterByQueue(@RequestBody TechnicianFilterDTO filterDTO) throws IOException;
}
