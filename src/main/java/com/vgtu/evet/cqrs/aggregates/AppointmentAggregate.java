package com.vgtu.evet.cqrs.aggregates;

import com.vgtu.evet.cqrs.commands.CreateAppointmentCommand;
import com.vgtu.evet.cqrs.commands.UpdateAppointmentCommand;
import com.vgtu.evet.entities.appointments.Appointment;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.entities.vetServices.AvailableTime;
import com.vgtu.evet.entities.vetServices.VetService;
import com.vgtu.evet.repository.AppointmentRepository;
import com.vgtu.evet.repository.AvailableTimeRepository;
import com.vgtu.evet.repository.PetRepository;
import com.vgtu.evet.repository.VetServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentAggregate {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private VetServiceRepository vetServiceRepository;

    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    @Autowired
    private PetRepository petRepository;

    public Appointment handleCreateAppointmentCommand(CreateAppointmentCommand appointmentCommand) {

//        Pet pet = petRepository.findById(appointmentCommand.getPetId()).orElse(null);
//        AvailableTime availableTime = availableTimeRepository.findById(appointmentCommand.getAvailableTimeId()).orElse(null);
//        VetService vetService = vetServiceRepository.findById(appointmentCommand.getVetServiceId()).orElse(null);
//
//        return appointmentRepository.save(Appointment.builder()
//                        .availableTime(availableTime)
//                        .vetService(vetService)
//                        .pet(pet)
//                        .ownersComment(appointmentCommand.getOwnersComment())
//                        .build());

        return appointmentRepository.save(Appointment.builder()
                        .vetService(appointmentCommand.getVetService())
                        .availableTime(appointmentCommand.getAvailableTime())
                        .pet(appointmentCommand.getPet())
                        .ownersComment(appointmentCommand.getOwnersComment())
                        .build());
    }

    public Appointment handleUpdateAppointmentCommand(UpdateAppointmentCommand appointmentCommand) {

        Appointment appointment = appointmentRepository.findById(appointmentCommand.getId()).orElse(null);

        if(appointmentCommand.getOwnersComment() != null) {
            appointment.setOwnersComment(appointmentCommand.getOwnersComment());
        }
        if(appointmentCommand.isCanceled()) {
            appointment.setCanceled(true);
        }

        return appointmentRepository.save(appointment);
    }
}
