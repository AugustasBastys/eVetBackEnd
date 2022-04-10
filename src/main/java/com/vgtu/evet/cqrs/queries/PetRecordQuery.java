package com.vgtu.evet.cqrs.queries;

import com.vgtu.evet.entities.petRecords.PetRecord;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.repository.PetRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetRecordQuery {

    @Autowired
    private PetRecordRepository petRecordRepository;

    public PetRecord getByRecordId(int id) {
        return  petRecordRepository.findById(id).orElse(null);
    }


    public PetRecord getByRecordPetId(int id) {
        return petRecordRepository.findByPetId(id);
    }
}
