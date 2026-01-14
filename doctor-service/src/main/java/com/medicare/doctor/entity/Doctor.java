package com.medicare.doctor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor_data")
@Getter
@Setter
@NoArgsConstructor
public class Doctor {

    @Id
    @Column(name = "doctor_id", nullable = false, updatable = false)
    private Long doctorId;   // PRIMARY KEY

    @Column(nullable = false)
    private String name;     // NOT UNIQUE (multiple doctors can share name)

    @Column(nullable = false)
    private String specialization;

    private Integer experience;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;
}
