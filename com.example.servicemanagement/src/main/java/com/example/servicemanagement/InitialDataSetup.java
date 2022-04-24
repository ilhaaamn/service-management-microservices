package com.example.servicemanagement;

import com.example.servicemanagement.entity.Brand;
import com.example.servicemanagement.entity.ServiceType;
import com.example.servicemanagement.entity.Technician;
import com.example.servicemanagement.repository.BrandRepository;
import com.example.servicemanagement.repository.CustomerRepository;
import com.example.servicemanagement.repository.ServiceTicketRepository;
import com.example.servicemanagement.repository.ServiceTypeRepository;
import com.example.servicemanagement.repository.TechnicianRepository;
import com.example.servicemanagement.util.PlatformEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.ParseException;

@Component
public class InitialDataSetup {
    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ServiceTicketRepository serviceTicketRepository;

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Autowired
    TechnicianRepository technicianRepository;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) throws ParseException {
        Brand brand = new Brand();
        brand.setName("Samsung");
        brand.setPlatform(PlatformEnum.ANDROID.getName());
        Brand storedBrandDTO = brandRepository.findBrandByName("samsung");
        if (storedBrandDTO == null) {
            brandRepository.save(brand);

        } else {
            brand = storedBrandDTO;
        }

        Brand brand2 = new Brand();
        brand2.setName("Xiaomi");
        brand2.setPlatform(PlatformEnum.ANDROID.getName());
        Brand storedBrandDTO2 = brandRepository.findBrandByName("xiaomi");
        if (storedBrandDTO2 == null) {
            brandRepository.save(brand2);
        } else {
            brand2 = storedBrandDTO2;
        }

        Brand brand3 = new Brand();
        brand3.setName("iphone");
        brand3.setPlatform(PlatformEnum.IOS.getName());
        Brand storedBrandDTO3 = brandRepository.findBrandByName("iphone");
        if (storedBrandDTO3 == null) {
            brandRepository.save(brand3);
        } else {
            brand3 = storedBrandDTO3;
        }

        Brand brand4 = new Brand();
        brand4.setName("Ipad");
        brand4.setPlatform(PlatformEnum.IOS.getName());
        Brand storedBrandDTO4 = brandRepository.findBrandByName("ipad");
        if (storedBrandDTO4 == null) {
            brandRepository.save(brand4);
        } else {
            brand4 = storedBrandDTO4;
        }

        Brand brand5 = new Brand();
        brand5.setName("Oppo");
        brand5.setPlatform(PlatformEnum.ANDROID.getName());
        Brand storedBrandDTO5 = brandRepository.findBrandByName("oppo");
        if (storedBrandDTO5 == null) {
            brandRepository.save(brand5);
        } else {
            brand5 = storedBrandDTO5;
        }

        Technician technician1 = new Technician();
        technician1.setName("gunawan");
        technician1.setSpecialization(brand);
        technician1.setPlatform(PlatformEnum.ANDROID.getName());
        technician1.setTotalQueue(0);
        Technician storedTechnicianDTO1 = technicianRepository.findTechnicianByName("gunawan");
        if (storedTechnicianDTO1 == null) {
            technicianRepository.save(technician1);
        } else {
            technician1 = storedTechnicianDTO1;
        }

        Technician technician2 = new Technician();
        technician2.setName("bobby");
        technician2.setSpecialization(brand2);
        technician2.setPlatform(PlatformEnum.ANDROID.getName());
        technician2.setTotalQueue(0);
        Technician storedTechnicianDTO2 = technicianRepository.findTechnicianByName("bobby");
        if (storedTechnicianDTO2 == null) {
            technicianRepository.save(technician2);
        } else {
            technician2 = storedTechnicianDTO2;
        }

        Technician technician3 = new Technician();
        technician3.setName("John");
        technician3.setSpecialization(brand3);
        technician3.setPlatform(PlatformEnum.IOS.getName());
        technician3.setTotalQueue(0);
        Technician storedTechnicianDTO3 = technicianRepository.findTechnicianByName("John");
        if (storedTechnicianDTO3 == null) {
            technicianRepository.save(technician3);
        } else {
            technician3 = storedTechnicianDTO3;
        }

        Technician technician4 = new Technician();
        technician4.setName("roger");
        technician4.setSpecialization(brand4);
        technician4.setPlatform(PlatformEnum.IOS.getName());
        technician4.setTotalQueue(0);
        Technician storedTechnicianDTO4 = technicianRepository.findTechnicianByName("roger");
        if (storedTechnicianDTO4 == null) {
            technicianRepository.save(technician4);
        } else {
            technician4 = storedTechnicianDTO4;
        }

        Technician technician5 = new Technician();
        technician5.setName("james");
        technician5.setSpecialization(brand5);
        technician5.setPlatform(PlatformEnum.IOS.getName());
        technician5.setTotalQueue(0);
        Technician storedTechnicianDTO5 = technicianRepository.findTechnicianByName("james");
        if (storedTechnicianDTO5 == null) {
            technicianRepository.save(technician5);
        } else {
            technician5 = storedTechnicianDTO5;
        }

        ServiceType serviceType1 = new ServiceType();
        serviceType1.setName("Mati Total");
        serviceType1.setTimeRequired(120);
        serviceType1.setPrice(BigDecimal.valueOf(300000));
        ServiceType storedServiceTypeDTO1 = serviceTypeRepository.findServiceTypeByName("Mati Total");
        if (storedServiceTypeDTO1 == null) {
            serviceTypeRepository.save(serviceType1);
        } else {
            serviceType1 = storedServiceTypeDTO1;
        }

        ServiceType serviceType2 = new ServiceType();
        serviceType2.setName("Boot Loop");
        serviceType2.setTimeRequired(90);
        serviceType2.setPrice(BigDecimal.valueOf(250000));
        ServiceType storedServiceTypeDTO2 = serviceTypeRepository.findServiceTypeByName("Boot Loop");
        if (storedServiceTypeDTO2 == null) {
            serviceTypeRepository.save(serviceType2);
        }

        ServiceType serviceType3 = new ServiceType();
        serviceType3.setName("Batre Bocor");
        serviceType3.setTimeRequired(60);
        serviceType3.setPrice(BigDecimal.valueOf(100000));
        ServiceType storedServiceTypeDTO3 = serviceTypeRepository.findServiceTypeByName("Batre Bocor");
        if (storedServiceTypeDTO3 == null) {
            serviceTypeRepository.save(serviceType3);
        }

        ServiceType serviceType4 = new ServiceType();
        serviceType4.setName("Layar Retak");
        serviceType4.setTimeRequired(60);
        serviceType4.setPrice(BigDecimal.valueOf(200000));
        ServiceType storedServiceTypeDTO4 = serviceTypeRepository.findServiceTypeByName("Layar Retak");
        if (storedServiceTypeDTO4 == null) {
            serviceTypeRepository.save(serviceType4);
        }
    }
}
