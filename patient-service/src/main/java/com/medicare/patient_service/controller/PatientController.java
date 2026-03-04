package com.medicare.patient_service.controller;

import com.medicare.patient_service.dto.PatientRequest;
import com.medicare.patient_service.dto.PatientResponse;
import com.medicare.patient_service.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PatientResponse> create(@RequestBody PatientRequest request) {
        return new ResponseEntity<>(service.createPatient(request), HttpStatus.CREATED);
    }

    @GetMapping("/{aadhaar}")
    public ResponseEntity<PatientResponse> getByAadhaar(@PathVariable String aadhaar) {
        return ResponseEntity.ok(service.getPatientByAadhaar(aadhaar));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAll() {
        return ResponseEntity.ok(service.getAllPatients());
    }

    @PutMapping("/{aadhaar}")
    public ResponseEntity<PatientResponse> update(
            @PathVariable String aadhaar,
            @RequestBody PatientRequest request) {
        return ResponseEntity.ok(service.updatePatient(aadhaar, request));
    }
}
