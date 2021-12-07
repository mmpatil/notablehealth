package com.notablehealth.interview.controller;

import com.notablehealth.interview.entity.Appointment;
import com.notablehealth.interview.entity.AppointmentsJsonObject;
import com.notablehealth.interview.entity.Doctor;
import com.notablehealth.interview.service.AppointmentService;
import com.notablehealth.interview.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController

public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/doctor/create")
    public ResponseEntity<Object> createDoctor(@RequestBody Doctor doctor){
        boolean result = doctorService.createDoctor(doctor);
       if(result){
           return ResponseEntity.ok("Doctor created!");
       }else{
           return ResponseEntity.ok("Doctor not created!");
       }
    }

    @DeleteMapping("/doctor/delete")
    public ResponseEntity<Object> deleteDoctor(@RequestBody Doctor doctor){
        boolean result = doctorService.deleteDoctor(doctor);
        if(result){
            return ResponseEntity.ok("Doctor deleted!");
        }else{
            return ResponseEntity.ok("Doctor not deleted!");
        }
    }

    @GetMapping("/doctors")
    public ResponseEntity<Object> getAllDoctors(){
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @DeleteMapping("/doctor/appointment/delete")
    public ResponseEntity<Object> deleteAppointmentForDoctor(@RequestBody AppointmentsJsonObject appointmentsJsonObject){
        Appointment appointment = new Appointment();
        appointment.setId(appointmentsJsonObject.getId());
        appointment.setFirstName(appointmentsJsonObject.getPatientFirstName());
        appointment.setLastName(appointmentsJsonObject.getPatientLastName());
        appointment.setDoctorId(appointmentsJsonObject.getDoctorId());
        appointment.setKind(appointmentsJsonObject.getKind());
        appointment.setTimeStamp(LocalDateTime.parse(appointmentsJsonObject.getAppointmentTime()));
        boolean result = appointmentService.deleteAppointment(appointment);
        if(result){
            return ResponseEntity.ok("Doctor Appointment deleted!");
        }else{
            return ResponseEntity.ok("Doctor Appointment not deleted!");
        }
    }

    @GetMapping("/doctor/appointments")
    public ResponseEntity<Object> getAppointments(@RequestParam String doctorId, @RequestParam String dateTime){
        LocalDateTime dateTime1 = LocalDateTime.parse(dateTime);
        return ResponseEntity.ok(appointmentService.getAppointments(doctorId, dateTime1));
    }
}
