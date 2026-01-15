package com.medicare.patient_service.service;

import com.medicare.patient_service.dto.PatientRequest;
import com.medicare.patient_service.dto.PatientResponse;

import java.util.List;

public interface PatientService {

    PatientResponse createPatient(PatientRequest request);

    PatientResponse getPatientByAadhaar(String aadhaarNumber);

    List<PatientResponse> getAllPatients();

    PatientResponse updatePatient(String aadhaarNumber, PatientRequest request);
}
