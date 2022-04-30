package com.vgtu.evet.cqrs.aggregates;

import com.vgtu.evet.cqrs.commands.CreatePetCommand;
import com.vgtu.evet.cqrs.commands.UpdatePetCommand;
import com.vgtu.evet.entities.appointments.Appointment;
import com.vgtu.evet.entities.pets.BreedType;
import com.vgtu.evet.entities.pets.GenderType;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.entities.vetServices.AvailableTime;
import com.vgtu.evet.entities.vetServices.VetService;
import com.vgtu.evet.repository.OwnedPetRepository;
import com.vgtu.evet.repository.PetRecordRepository;
import com.vgtu.evet.repository.PetRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class PetAggregateTest {

    private static final long UNIX_TIME_STAMP_MAY_12 = 1652335200;
    private static final String DOG_NAME = "Barky";
    private static final String USER_ID = "1";
    private static final int PET_ID = 0;
    private static final String COLOR = "Black";
    private static final String NEW_COLOR = "Grey";
    private static final String NEW_NAME = "Dogmeat";

    private Pet pet;
    private CreatePetCommand createPetCommand;
    private UpdatePetCommand updatePetCommand;

    @MockBean
    private PetRepository petRepository;

    @MockBean
    private OwnedPetRepository ownedPetRepository;

    @MockBean
    private PetRecordRepository petRecordRepository;

    @Autowired
    private PetAggregate petAggregate;

    @BeforeEach
    void setUp() {
        createPetCommand = CreatePetCommand.builder().name(DOG_NAME).color(COLOR).birthDay(new Date(UNIX_TIME_STAMP_MAY_12))
                .genderType(GenderType.Male).sterilized(false).breed(BreedType.Canine).build();

        pet = Pet.builder().name(DOG_NAME).id(PET_ID).sterilized(false).birthday(new Date(UNIX_TIME_STAMP_MAY_12))
                .gender(GenderType.Male).color(COLOR).breed(BreedType.Canine)
                .build();

        updatePetCommand = UpdatePetCommand.builder().id(PET_ID).build();

        Mockito.when(petRepository.save(pet)).thenReturn(pet);
        Mockito.when(petRepository.findById(pet.getId())).thenReturn(Optional.of(pet));
    }

    @Test
    void checkHandleCreatePetCommand() {
        Assert.assertEquals(pet, petAggregate.handleCreatePetCommand(createPetCommand, USER_ID));
    }

    @Test
    void checkHandleUpdatePetCommandColor() {
        updatePetCommand.setColor(NEW_COLOR);
        pet.setColor(NEW_COLOR);
        Assert.assertEquals(pet, petAggregate.handleUpdatePetCommand(updatePetCommand));
    }

    @Test
    void checkHandleUpdatePetCommandSterilized() {
        updatePetCommand.setSterilized(true);
        pet.setSterilized(true);
        Assert.assertEquals(pet, petAggregate.handleUpdatePetCommand(updatePetCommand));
    }

    @Test
    void checkHandleUpdatePetCommandName() {
        updatePetCommand.setName(NEW_NAME);
        pet.setName(NEW_NAME);
        Assert.assertEquals(pet, petAggregate.handleUpdatePetCommand(updatePetCommand));
    }

    @Test
    void checkHandleUpdatePetCommandHidden() {
        updatePetCommand.setHidden(true);
        pet.setHidden(true);
        Assert.assertEquals(pet, petAggregate.handleUpdatePetCommand(updatePetCommand));
    }
}