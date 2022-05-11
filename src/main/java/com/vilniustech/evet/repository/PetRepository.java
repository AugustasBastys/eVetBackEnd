package com.vilniustech.evet.repository;

import com.vilniustech.evet.entities.pets.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
