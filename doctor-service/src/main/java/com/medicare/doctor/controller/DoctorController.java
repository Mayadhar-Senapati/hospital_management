package com.medicare.doctor.controller;

import com.medicare.doctor.dto.DoctorRequest;
import com.medicare.doctor.dto.DoctorResponse;
import com.medicare.doctor.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponse create(@Valid @RequestBody DoctorRequest request) {
        return service.createDoctor(request);
    }

    @GetMapping
    public List<DoctorResponse> getAll() {
        return service.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorResponse getById(@PathVariable Long id) {
        return service.getDoctorById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deleteDoctor(id);
    }
}
