package com.medicare.doctor.service;

import com.medicare.doctor.dto.DoctorRequest;
import com.medicare.doctor.dto.DoctorResponse;
import com.medicare.doctor.entity.Doctor;
import com.medicare.doctor.exception.DoctorNotFoundException;
import com.medicare.doctor.mapper.DoctorMapper;
import com.medicare.doctor.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    @Override
    public DoctorResponse createDoctor(DoctorRequest request) {

            
            if (repository.existsById(request.getDoctorId())) {
                throw new IllegalStateException(
                    "Doctor with ID " + request.getDoctorId() + " already exists"
                );
            }

        Doctor doctor = DoctorMapper.toEntity(request);
        Doctor savedDoctor = repository.save(doctor);

        return DoctorMapper.toResponse(savedDoctor);
    }


    @Override
    public List<DoctorResponse> getAllDoctors() {
        return repository.findAll()
                .stream()
                .map(DoctorMapper::toResponse)
                .toList();
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        Doctor doctor = repository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException(id));
        return DoctorMapper.toResponse(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        if (!repository.existsById(id)) {
            throw new DoctorNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
