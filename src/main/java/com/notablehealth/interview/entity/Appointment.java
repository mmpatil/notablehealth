package com.notablehealth.interview.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="appointments", schema="notable")
public class Appointment {

    @Id
    @GenericGenerator(name = "db-uuid", strategy = "guid")
    @GeneratedValue(generator = "db-uuid")
//    @Column(name="id")
    private String id;

    private String patientFirstName;

//    @Column(name="patientLastName")
    private String patientLastName;

//    @Column(name="appointmenttime")
    private LocalDateTime appointmentTime;

//    @Column(name="kind")
    private String kind;

//    @Column(name="doctorId")
    private String doctorId;

    public Appointment(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return patientFirstName;
    }

    public void setFirstName(String firstName) {
        this.patientFirstName = firstName;
    }

    public String getLastName() {
        return patientLastName;
    }

    public void setLastName(String lastName) {
        this.patientLastName = lastName;
    }

    public LocalDateTime getTimeStamp() {
        return appointmentTime;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.appointmentTime = timeStamp;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
