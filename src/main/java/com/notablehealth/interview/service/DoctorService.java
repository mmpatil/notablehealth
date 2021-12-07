package com.notablehealth.interview.service;

import com.notablehealth.interview.entity.Doctor;
import com.notablehealth.interview.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public boolean createDoctor(Doctor doctor){
            doctorRepository.save(doctor);
            return true;
    }

    public boolean deleteDoctor(Doctor doctor){
        Optional<Doctor> doctor1 = doctorRepository.findById(doctor.getId());
        if(doctor1.isPresent()){
            doctorRepository.delete(doctor);
            return true;
        }
        return false;
    }

    public List<Doctor> getAllDoctors(){
        return doctorRepository.findAll();
    }
}
