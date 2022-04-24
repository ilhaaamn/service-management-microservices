package com.example.servicemanagement.ui.controller.common;

import com.example.servicemanagement.service.common.AbstractEntityService;
import com.example.servicemanagement.service.dto.filter.ServiceTicketFilterDTO;
import com.example.servicemanagement.ui.model.RequestId;
import com.example.servicemanagement.util.Identifiable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractController<T extends Identifiable<ID>, D extends Identifiable<ID>, S extends AbstractEntityService<T, D, ID>, ID extends Serializable> {
    protected final S service;

    protected AbstractController(S service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<D> findAll() {
        return service.findAll();
    }

    @PostMapping("/getById")
    public D getById(@RequestBody RequestId<ID> requestId) {
        return service.findOne(requestId.getId()).orElseThrow(() -> new EntityNotFoundException("Entity with id " + requestId.getId() + " not found"));
    }

    @PostMapping("/add")
    public D add(@RequestBody D dto) {
        return service.save(dto);
    }

    @PostMapping("/update")
    public D update(@RequestBody D dto) {
        return service.update(dto);
    }

    @PostMapping("/deleteById")
    public void delete(@RequestBody RequestId<ID> requestId) {
        service.delete(requestId.getId());
    }

    @PostMapping("/delete")
    public void delete(@RequestBody D dto) {
        service.delete(dto);
    }
}
