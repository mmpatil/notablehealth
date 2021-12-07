package com.notablehealth.interview.service;

import com.notablehealth.interview.entity.Appointment;
import com.notablehealth.interview.entity.Doctor;
import com.notablehealth.interview.repository.AppointmentRepository;
import com.notablehealth.interview.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public boolean createAppointment(Appointment appointment){
        Optional<Doctor> doctor = doctorRepository.findById(appointment.getDoctorId());
         if(doctor.isPresent()){
            List<Appointment> appointmentList = appointmentRepository.findByDoctorIdAndTime(appointment.getDoctorId(), appointment.getTimeStamp());
            if(appointmentList.size() < 3){;
                appointmentRepository.save(appointment);
                return true;
            }
         }
         return false;
    }

    public boolean deleteAppointment(Appointment appointment){
        Optional<Appointment> appt = appointmentRepository.findById(appointment.getId());
        if(appt.isPresent()){
            appointmentRepository.delete(appointment);
            return true;
        }
        return false;
    }

    public List<Appointment> getAppointments(String doctorId, LocalDateTime dateTime){
        LocalDate date = dateTime.toLocalDate();
        return appointmentRepository.findByDoctorIdAndDay(doctorId, date);
    }

}
