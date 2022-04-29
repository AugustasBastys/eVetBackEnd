package com.vgtu.evet.cqrs.aggregates;

import com.vgtu.evet.cqrs.commands.CreateAppointmentCommand;
import com.vgtu.evet.cqrs.commands.UpdateAppointmentCommand;
import com.vgtu.evet.entities.appointments.Appointment;
import com.vgtu.evet.entities.pets.BreedType;
import com.vgtu.evet.entities.pets.GenderType;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.entities.vetServices.AvailableTime;
import com.vgtu.evet.entities.vetServices.VetService;
import com.vgtu.evet.repository.AppointmentRepository;
import com.vgtu.evet.repository.AvailableTimeRepository;
import com.vgtu.evet.repository.PetRepository;
import com.vgtu.evet.repository.VetServiceRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AppointmentAggregateTest {

    private static final long UNIX_TIME_STAMP_MAY_12 = 1652335200;
    private static final String DOG_NAME = "Barky";
    private static final String COLOR = "Black";
    private static final String SERVICE_NAME = "General check up";
    private static final String SERVICE_CODE = "gen";
    private static final String OWNERS_COMMENT = "Comment";
    private static final int PRICE = 20;
    private static final int ID = 1;

    private Pet pet;
    private AvailableTime availableTime;
    private VetService vetService;
    private CreateAppointmentCommand appointmentCommand;
    private Appointment appointment;
    private UpdateAppointmentCommand updateAppointmentCommand;

    @Autowired
    private AppointmentAggregate appointmentAggregate;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @MockBean
    private PetRepository petRepository;

    @MockBean
    private AvailableTimeRepository availableTimeRepository;

    @MockBean
    private VetServiceRepository vetServiceRepository;


    @BeforeEach
    void setUp() {

        pet = Pet.builder().name(DOG_NAME).sterilized(true).gender(GenderType.Male).color(COLOR).breed(BreedType.Canine)
                .id(ID).build();
        availableTime = AvailableTime.builder().id(ID).date(new Date(UNIX_TIME_STAMP_MAY_12)).build();
        vetService = VetService.builder().id(ID).name(SERVICE_NAME).price(PRICE).vetServiceCode(SERVICE_CODE).build();

        appointmentCommand = CreateAppointmentCommand.builder()
                .availableTimeId(availableTime.getId()).vetServiceId(vetService.getId()).petId(pet.getId()).build();

        appointment = Appointment.builder().pet(pet).availableTime(availableTime).vetService(vetService).build();

        updateAppointmentCommand = UpdateAppointmentCommand.builder().id(ID).build();

        Mockito.when(petRepository.findById(pet.getId())).thenReturn(Optional.of(pet));
        Mockito.when(availableTimeRepository.findById(availableTime.getId())).thenReturn(Optional.of(availableTime));
        Mockito.when(vetServiceRepository.findById(vetService.getId())).thenReturn(Optional.of(vetService));
        Mockito.when(appointmentRepository.save(appointment)).thenReturn(appointment);
        Mockito.when(appointmentRepository.findById(updateAppointmentCommand.getId())).thenReturn(Optional.of(appointment));
    }

    @Test
    void checkHandleCreateAppointmentCommandUpdatesAvailableTimeBooked() {
        Appointment returnedAppointment = appointmentAggregate.handleCreateAppointmentCommand(appointmentCommand);
        Assert.assertEquals(true, returnedAppointment.getAvailableTime().isBooked());
    }

    @Test
    void checkHandleCreateAppointmentCommand() {
        Assert.assertEquals(appointment, appointmentAggregate.handleCreateAppointmentCommand(appointmentCommand));
    }

    @Test
    void checkHandleUpdateAppointmentCommandWithComment() {
        updateAppointmentCommand.setOwnersComment(OWNERS_COMMENT);
        Assert.assertEquals(OWNERS_COMMENT, appointmentAggregate.handleUpdateAppointmentCommand(updateAppointmentCommand).getOwnersComment());
    }

    @Test
    void checkHandleUpdateAppointmentCommandWithCancellation() {
        updateAppointmentCommand.setCanceled(true);
        Assert.assertEquals(true, appointmentAggregate.handleUpdateAppointmentCommand(updateAppointmentCommand).isCanceled());
        Assert.assertEquals(false, appointmentAggregate.handleUpdateAppointmentCommand(updateAppointmentCommand).getAvailableTime().isBooked());
    }

}