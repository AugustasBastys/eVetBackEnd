package com.vgtu.evet.cqrs.queries;

import com.vgtu.evet.entities.appointments.Appointment;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppointmentQuery {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment getById(int id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public List<Appointment> getByPetId(int id) {
        return appointmentRepository.findByPetIdAndCanceledFalse(id);
    }
}
