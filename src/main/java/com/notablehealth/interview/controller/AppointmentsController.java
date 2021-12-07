package com.notablehealth.interview.controller;

import com.notablehealth.interview.entity.Appointment;
import com.notablehealth.interview.entity.AppointmentsJsonObject;
import com.notablehealth.interview.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
public class AppointmentsController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointment/create")
    public ResponseEntity<Object> createAppointment(@RequestBody AppointmentsJsonObject appointmentsJsonObject){

        Appointment appointment = new Appointment();
        appointment.setFirstName(appointmentsJsonObject.getPatientFirstName());
        appointment.setLastName(appointmentsJsonObject.getPatientLastName());
        appointment.setDoctorId(appointmentsJsonObject.getDoctorId());
        appointment.setKind(appointmentsJsonObject.getKind());
        appointment.setTimeStamp(LocalDateTime.parse(appointmentsJsonObject.getAppointmentTime()));
        if(appointment.getTimeStamp().getMinute() == 0 || appointment.getTimeStamp().getMinute() == 15 ||
                appointment.getTimeStamp().getMinute() == 30 || appointment.getTimeStamp().getMinute() == 45 &&
                appointment.getTimeStamp().getSecond() == 0){
            boolean result = appointmentService.createAppointment(appointment);
            if(result){
                return ResponseEntity.ok("Appointment created!");
            }else{
                return ResponseEntity.ok("Appointment not created!");
            }
        }
        return ResponseEntity.ok("Appointment not created!");
    }
}
