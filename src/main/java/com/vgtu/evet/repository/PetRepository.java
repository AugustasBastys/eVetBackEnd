package com.vgtu.evet.repository;

import com.vgtu.evet.entities.pets.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
