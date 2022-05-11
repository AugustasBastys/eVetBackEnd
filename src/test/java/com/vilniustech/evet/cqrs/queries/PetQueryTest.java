package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.pets.BreedType;
import com.vilniustech.evet.entities.pets.GenderType;
import com.vilniustech.evet.entities.pets.OwnedPet;
import com.vilniustech.evet.entities.pets.Pet;
import com.vilniustech.evet.repository.OwnedPetRepository;
import com.vilniustech.evet.repository.PetRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class PetQueryTest {

    private static final String DOG_NAME = "Barky";
    private static final String COLOR = "Black";
    private static final int ID = 1;
    private static final String USER_ID = "1";

    private Pet pet1;
    private Pet pet2;

    List<OwnedPet> ownedPetList;
    private OwnedPet ownedPet1;
    private OwnedPet ownedPet2;

    @MockBean
    private PetRepository petRepository;

    @MockBean
    private OwnedPetRepository ownedPetRepository;

    @Autowired
    private PetQuery petQuery;

    @BeforeEach
    void setUp() {

        pet1 = Pet.builder().name(DOG_NAME).sterilized(true).gender(GenderType.Male).color(COLOR).breed(BreedType.Canine)
                .id(ID).build();
        pet2 = Pet.builder().name(DOG_NAME).sterilized(true).gender(GenderType.Male).color(COLOR).breed(BreedType.Canine)
                .id(ID+1).hidden(true).build();

        ownedPet1 = OwnedPet.builder().id(ID).pet(pet1).petOwner(USER_ID).build();
        ownedPet2 = OwnedPet.builder().id(ID + 1).pet(pet2).petOwner(USER_ID).build();


        Mockito.when(petRepository.findById(pet1.getId())).thenReturn(Optional.of(pet1));
        Mockito.when(petRepository.findById(pet2.getId())).thenReturn(Optional.of(pet2));
        Mockito.when(ownedPetRepository.findAllOwnedPetsByUserId(USER_ID)).thenReturn(List.of(ownedPet1, ownedPet2));

    }

    @Test
    void checkGetById() {
        Assert.assertEquals(pet1, petQuery.getById(ID));
    }

    @Test
    void checkGetByOwnersId() {
        Assert.assertEquals(List.of(pet1, pet2), petQuery.getByOwnersId(USER_ID));
    }
}