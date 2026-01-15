package com.medicare.patient_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PatientResponse {

    private Long id;
    private String aadhaarNumber;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String phoneNumber;
    private String address;

    // getters & setters
}
