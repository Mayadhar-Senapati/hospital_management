package com.medicare.patient_service.service;

import com.medicare.patient_service.dto.PatientRequest;
import com.medicare.patient_service.dto.PatientResponse;
import com.medicare.patient_service.entity.Patient;
import com.medicare.patient_service.exception.PatientNotFoundException;
import com.medicare.patient_service.mapper.PatientMapper;
import com.medicare.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientResponse createPatient(PatientRequest request) {
        Patient patient = PatientMapper.toEntity(request);
        return PatientMapper.toResponse(repository.save(patient));
    }

    @Override
    public PatientResponse getPatientByAadhaar(String aadhaarNumber) {
        Patient patient = repository.findByAadhaarNumber(aadhaarNumber)
                .orElseThrow(() ->
                        new PatientNotFoundException("Patient not found with Aadhaar: " + aadhaarNumber));
        return PatientMapper.toResponse(patient);
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return repository.findAll()
                .stream()
                .map(PatientMapper::toResponse)
                .toList();
    }

    @Override
    public PatientResponse updatePatient(String aadhaarNumber, PatientRequest request) {
        Patient patient = repository.findByAadhaarNumber(aadhaarNumber)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setAddress(request.getAddress());

        return PatientMapper.toResponse(repository.save(patient));
    }
}
