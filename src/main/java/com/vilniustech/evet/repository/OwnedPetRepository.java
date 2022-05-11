package com.vilniustech.evet.repository;

import com.vilniustech.evet.entities.pets.OwnedPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnedPetRepository extends JpaRepository<OwnedPet, Integer> {

    @Query("SELECT o FROM OwnedPet o where o.petOwner = :ownersId")
    List<OwnedPet> findAllOwnedPetsByUserId(@Param("ownersId") String id);

}
