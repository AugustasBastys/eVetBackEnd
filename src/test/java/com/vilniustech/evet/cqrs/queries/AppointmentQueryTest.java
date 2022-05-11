package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.appointments.Appointment;
import com.vilniustech.evet.entities.pets.BreedType;
import com.vilniustech.evet.entities.pets.GenderType;
import com.vilniustech.evet.entities.pets.Pet;
import com.vilniustech.evet.entities.vetServices.AvailableTime;
import com.vilniustech.evet.entities.vetServices.VetService;
import com.vilniustech.evet.repository.AppointmentRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class AppointmentQueryTest {


    private static final String USER_ID = "1";
    private static final long UNIX_TIME_STAMP_MAY_12 = 1652335200;
    private static final String DOG_NAME = "Barky";
    private static final String COLOR = "Black";
    private static final String SERVICE_NAME = "General check up";
    private static final String SERVICE_CODE = "gen";
    private static final int PRICE = 20;
    private static final int ID = 1;

    private Pet pet;
    private AvailableTime availableTime1;
    private AvailableTime availableTime2;
    private VetService vetService;

    private Appointment appointment1;
    private Appointment appointment2;
    private List<Appointment> appointmentList;
    private List<Pet> petList;

    @MockBean
    private PetQuery petQuery;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentQuery appointmentQuery;

    @BeforeEach
    void setUp() {

        pet = Pet.builder().name(DOG_NAME).sterilized(true).gender(GenderType.Male).color(COLOR).breed(BreedType.Canine)
                .id(ID).build();
        availableTime1 = AvailableTime.builder().id(ID).date(new Date(UNIX_TIME_STAMP_MAY_12)).build();
        availableTime2 = AvailableTime.builder().id(ID).date(new Date(UNIX_TIME_STAMP_MAY_12+1)).build();
        vetService = VetService.builder().id(ID).name(SERVICE_NAME).price(PRICE).vetServiceCode(SERVICE_CODE).build();

        appointment1 = Appointment.builder().pet(pet).availableTime(availableTime1).vetService(vetService).build();
        appointment2 = Appointment.builder().pet(pet).availableTime(availableTime2).vetService(vetService).build();

        appointmentList = new ArrayList<>();
        appointmentList.add(appointment1);
        appointmentList.add(appointment2);

        petList = new ArrayList<>();
        petList.add(pet);

        Mockito.when(petQuery.getByOwnersId(USER_ID)).thenReturn(petList);
        Mockito.when(appointmentRepository.findByPetIdOrderByAvailableTimeDateAsc(ID)).thenReturn(appointmentList);
    }

    @Test
    void checkGetAllUserPetsAppointments() {
        Assert.assertEquals(appointmentList, appointmentQuery.getAllUserPetsAppointments(USER_ID));
    }

    @Test
    void checkGetByPetId() {
        Assert.assertEquals(appointmentList, appointmentQuery.getByPetId(ID));
    }
}