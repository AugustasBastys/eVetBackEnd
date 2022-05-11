package com.vilniustech.evet.repository;

import com.vilniustech.evet.entities.petRecords.PetRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRecordRepository extends JpaRepository<PetRecord, Integer> {
    PetRecord findByPetId(int id);
}
