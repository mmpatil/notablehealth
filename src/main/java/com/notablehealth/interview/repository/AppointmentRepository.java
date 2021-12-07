package com.notablehealth.interview.repository;

import com.notablehealth.interview.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {

    public List<Appointment> findByDoctorId(String doctorId);

    public Optional<Appointment> findById(String id);

    @Query("select appt from Appointment appt where appt.doctorId= ?1 and appt.appointmentTime = ?2")
    public List<Appointment> findByDoctorIdAndTime(String doctorId, LocalDateTime time);

    @Query(value="select appt.* from appointments appt where appt.doctor_id= ?1 and DATE(appt.appointment_time) = ?2", nativeQuery = true)
    public List<Appointment> findByDoctorIdAndDay(String doctorId, LocalDate date);
}
