package com.notablehealth.interview.repository;

import com.notablehealth.interview.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, String> {

    public Optional<Doctor> findById(String id);

}
