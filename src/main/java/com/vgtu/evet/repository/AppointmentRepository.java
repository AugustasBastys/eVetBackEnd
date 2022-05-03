package com.vgtu.evet.repository;

import com.vgtu.evet.entities.appointments.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByPetId(int id);
}
