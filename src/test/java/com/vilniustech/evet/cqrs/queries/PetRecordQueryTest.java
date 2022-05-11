package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.petRecords.Condition;
import com.vilniustech.evet.entities.petRecords.PetRecord;
import com.vilniustech.evet.entities.petRecords.log.Surgery;
import com.vilniustech.evet.entities.petRecords.log.Vaccination;
import com.vilniustech.evet.entities.petRecords.log.VaccineType;
import com.vilniustech.evet.entities.petRecords.log.Visit;
import com.vilniustech.evet.entities.pets.BreedType;
import com.vilniustech.evet.entities.pets.GenderType;
import com.vilniustech.evet.entities.pets.Pet;
import com.vilniustech.evet.entities.vetServices.VetService;
import com.vilniustech.evet.repository.PetRecordRepository;
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
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class PetRecordQueryTest {

    private static final String DOG_NAME = "Barky";
    private static final String COLOR = "Black";
    private static final int ID = 1;
    private static final int UNIX_TIME = 1000;
    private static final int PULSE = 80;
    private static final String CONDITION = "Condition";
    private static final String CONDITION_DESC = "Description";
    private static final String NOTE = "Something";
    private static final String DIAGNOSIS = "Something";
    private static final String BLOOD_PRESSURE = "120/80";
    private static final double TEMP = 37;
    private static final double WEIGTH = 20;
    private static final Date DATE = new Date(UNIX_TIME);

    private Pet pet;

    private PetRecord petRecord;

    private Surgery surgery;

    private Vaccination vaccination;

    private Visit visit;

    private Condition condition;

    private List<VetService> vetServiceList;

    @MockBean
    private PetRecordRepository petRecordRepository;

    @Autowired
    private PetRecordQuery petRecordQuery;

    @BeforeEach
    void setUp() {

        visit = Visit.builder().id(ID).date(DATE).bloodPressure(BLOOD_PRESSURE)
                .diagnosis(DIAGNOSIS)
                .pulse(PULSE).weight(WEIGTH).temp(TEMP).build();

        petRecord = PetRecord.builder().id(ID).build();

        pet = Pet.builder().name(DOG_NAME).sterilized(true).gender(GenderType.Male).color(COLOR).breed(BreedType.Canine)
                .id(ID).build();
        surgery = Surgery.builder().id(ID).visit(visit).petRecord(petRecord).note(NOTE).build();
        vaccination = Vaccination.builder().id(ID).visit(visit).petRecord(petRecord).nextDue(DATE).vaccineType(VaccineType.Hepatitis).build();
        condition = Condition.builder().conditionName(CONDITION).note(CONDITION_DESC).build();

       petRecord.setPet(pet);
       petRecord.setConditions(List.of(condition));
       petRecord.setVaccinations(List.of(vaccination));
       petRecord.setSurgeries(List.of(surgery));
       petRecord.setVisits(List.of(visit));

        Mockito.when(petRecordRepository.findById(ID)).thenReturn(Optional.of(petRecord));
        Mockito.when(petRecordRepository.findByPetId(ID)).thenReturn(petRecord);
    }


    @Test
    void checkGetByPetId() {
        Assert.assertEquals(petRecord, petRecordQuery.getByRecordPetId(ID));
    }

    @Test
    void checkGetById() {
        Assert.assertEquals(petRecord, petRecordQuery.getByRecordId(ID));
    }

}
