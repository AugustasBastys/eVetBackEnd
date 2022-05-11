package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.petRecords.PetRecord;
import com.vilniustech.evet.repository.PetRecordRepository;
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
