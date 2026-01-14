package com.medicare.doctor.dto;

import lombok.Data;

@Data
public class DoctorResponse {

    private Long doctorId;
    private String name;
    private String specialization;
    private Integer experience;
    private String email;
    private String phone;
}
