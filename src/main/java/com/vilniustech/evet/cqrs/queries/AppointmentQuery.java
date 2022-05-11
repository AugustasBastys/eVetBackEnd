package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.appointments.Appointment;
import com.vilniustech.evet.entities.pets.Pet;
import com.vilniustech.evet.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
        return appointmentRepository.findByPetIdOrderByAvailableTimeDateAsc(id);
    }

    public List<Appointment> getAllUserPetsAppointments(String userId) {
        List<Pet> pets = petQuery.getByOwnersId(userId);
        List<Appointment> appointments = new ArrayList<>();

        pets.forEach(pet -> {
            appointments.addAll(getByPetId(pet.getId()));
        });

        Collections.sort(appointments, new Comparator<Appointment>(){
            @Override
            public int compare(Appointment a1, Appointment a2) {
//                if(a1.getAvailableTime().getDate() == a2.getAvailableTime().getDate())

//                if(a1.getAvailableTime().getDate().compareTo(a2.getAvailableTime().getDate())) {
//                    return  -1;
//                }
                return a1.getAvailableTime().getDate().compareTo(a2.getAvailableTime().getDate());
            }
        });

        return appointments;
    }
}
