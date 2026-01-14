package com.medicare.doctor.service;

import com.medicare.doctor.dto.DoctorRequest;
import com.medicare.doctor.dto.DoctorResponse;

import java.util.List;

public interface DoctorService {

    DoctorResponse createDoctor(DoctorRequest request);

    List<DoctorResponse> getAllDoctors();

    DoctorResponse getDoctorById(Long doctorId);

    void deleteDoctor(Long doctorId);
}
