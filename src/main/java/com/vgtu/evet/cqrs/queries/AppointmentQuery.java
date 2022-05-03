package com.vgtu.evet.cqrs.queries;

import com.vgtu.evet.entities.appointments.Appointment;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentQuery {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PetQuery petQuery;
    
    public Appointment getById(int id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public List<Appointment> getByPetId(int id) {
        return appointmentRepository.findByPetId(id);
    }

    public List<Appointment> getAllUserPetsAppointments(String userId) {
        List<Pet> pets = petQuery.getByOwnersId(userId);
        List<Appointment> appointments = new ArrayList<>();

        pets.forEach(pet -> {
            appointments.addAll(getByPetId(pet.getId()));
        });

        return appointments;
    }
}
