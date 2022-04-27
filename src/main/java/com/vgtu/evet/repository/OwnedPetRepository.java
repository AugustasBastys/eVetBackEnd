package com.vgtu.evet.repository;

import com.vgtu.evet.entities.pets.OwnedPet;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnedPetRepository extends JpaRepository<OwnedPet, Integer> {

    @Query("SELECT o FROM OwnedPet o where o.petOwner = :ownersId")
    List<OwnedPet> findAllOwnedPetsByUserId(@Param("ownersId") String id);

}
