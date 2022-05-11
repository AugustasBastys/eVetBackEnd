package com.vilniustech.evet.repository;

import com.vilniustech.evet.entities.vetServices.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Integer> {
    List<Veterinarian> findByVetServiceId(int id);
}
