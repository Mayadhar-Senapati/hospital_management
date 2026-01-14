package com.medicare.doctor.mapper;

import com.medicare.doctor.dto.DoctorRequest;
import com.medicare.doctor.dto.DoctorResponse;
import com.medicare.doctor.entity.Doctor;

public class DoctorMapper {

    private DoctorMapper() {}

    public static Doctor toEntity(DoctorRequest request) {
        Doctor doctor = new Doctor();

        // If doctorId comes from request (manual assignment)
        doctor.setDoctorId(request.getDoctorId());

        doctor.setName(request.getName());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setExperience(request.getExperience());
        doctor.setEmail(request.getEmail());
        doctor.setPhone(request.getPhone());

        return doctor;
    }

    public static DoctorResponse toResponse(Doctor doctor) {
        DoctorResponse response = new DoctorResponse();

        response.setDoctorId(doctor.getDoctorId());
        response.setName(doctor.getName());
        response.setSpecialization(doctor.getSpecialization());
        response.setExperience(doctor.getExperience());
        response.setEmail(doctor.getEmail());
        response.setPhone(doctor.getPhone());

        return response;
    }
}
