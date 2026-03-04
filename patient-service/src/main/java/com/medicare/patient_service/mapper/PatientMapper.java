package com.medicare.patient_service.mapper;

import com.medicare.patient_service.dto.PatientRequest;
import com.medicare.patient_service.dto.PatientResponse;
import com.medicare.patient_service.entity.Patient;

public class PatientMapper {

    public static Patient toEntity(PatientRequest request) {
        Patient patient = new Patient();
        patient.setAadhaarNumber(request.getAadhaarNumber());
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setAge(request.getAge());
        patient.setGender(request.getGender());
        patient.setPhoneNumber(request.getPhoneNumber());
        patient.setAddress(request.getAddress());
        return patient;
    }

    public static PatientResponse toResponse(Patient patient) {
        PatientResponse response = new PatientResponse();
        response.setId(patient.getId());
        response.setAadhaarNumber(patient.getAadhaarNumber());
        response.setFirstName(patient.getFirstName());
        response.setLastName(patient.getLastName());
        response.setAge(patient.getAge());
        response.setGender(patient.getGender());
        response.setPhoneNumber(patient.getPhoneNumber());
        response.setAddress(patient.getAddress());
        return response;
    }
}
