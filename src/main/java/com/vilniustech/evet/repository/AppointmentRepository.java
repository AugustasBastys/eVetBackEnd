package com.vilniustech.evet.repository;

import com.vilniustech.evet.entities.appointments.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    List<Appointment> findByPetIdOrderByAvailableTimeDateAsc(int id);
}
