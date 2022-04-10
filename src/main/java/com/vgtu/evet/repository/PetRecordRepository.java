package com.vgtu.evet.repository;

import com.vgtu.evet.entities.petRecords.PetRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRecordRepository extends JpaRepository<PetRecord, Integer> {
    PetRecord findByPetId(int id);
}
