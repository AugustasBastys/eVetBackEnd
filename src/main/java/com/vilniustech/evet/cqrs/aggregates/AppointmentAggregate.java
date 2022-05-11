package com.vilniustech.evet.cqrs.aggregates;

import com.vilniustech.evet.cqrs.commands.CreateAppointmentCommand;
import com.vilniustech.evet.cqrs.commands.CancelAppointmentCommand;
import com.vilniustech.evet.cqrs.commands.RescheduleAppointmentCommand;
import com.vilniustech.evet.entities.appointments.Appointment;
import com.vilniustech.evet.entities.pets.Pet;
import com.vilniustech.evet.entities.vetServices.AvailableTime;
import com.vilniustech.evet.entities.vetServices.VetService;
import com.vilniustech.evet.repository.AppointmentRepository;
import com.vilniustech.evet.repository.AvailableTimeRepository;
import com.vilniustech.evet.repository.PetRepository;
import com.vilniustech.evet.repository.VetServiceRepository;
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

        Pet pet = petRepository.findById(appointmentCommand.getPetId()).orElse(null);
        AvailableTime availableTime = availableTimeRepository.findById(appointmentCommand.getAvailableTimeId()).orElse(null);
        availableTime.setBooked(true);
        VetService vetService = vetServiceRepository.findById(appointmentCommand.getVetServiceId()).orElse(null);

        return appointmentRepository.save(Appointment.builder()
                        .availableTime(availableTime)
                        .vetService(vetService)
                        .pet(pet)
                        .ownersComment(appointmentCommand.getOwnersComment())
                        .build());
// npx swagger-typescript-api -p http://localhost:8080/v2/api-docs -o ./src/apiClient -n myApi.t
    }

    public Appointment handleCancelAppointmentCommand(CancelAppointmentCommand appointmentCommand) {

        Appointment appointment = appointmentRepository.findById(appointmentCommand.getId()).orElse(null);

            appointment.setCanceled(true);
            AvailableTime availableTime = availableTimeRepository.findById(appointment.getAvailableTime().getId()).orElse(null);
            availableTime.setBooked(false);
            appointment.setAvailableTime(availableTime);

        return appointmentRepository.save(appointment);
    }

    public Appointment handleRescheduleAppointmentCommand(RescheduleAppointmentCommand appointmentCommand) {

        Appointment appointment = appointmentRepository.findById(appointmentCommand.getId()).orElse(null);

            AvailableTime availableTime = availableTimeRepository.findById(appointment.getAvailableTime().getId()).orElse(null);
            availableTime.setBooked(false);

            AvailableTime newAvailableTime = availableTimeRepository.findById(appointmentCommand.getAvailableTimeId()).orElse(null);
            newAvailableTime.setBooked(true);
            appointment.setAvailableTime(newAvailableTime);



        return appointmentRepository.save(appointment);
    }

}
