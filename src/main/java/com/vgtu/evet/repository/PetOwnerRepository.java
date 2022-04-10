package com.vgtu.evet.repository;

import com.vgtu.evet.entities.pets.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetOwnerRepository extends JpaRepository<PetOwner, Integer> {

    @Query( "select o from PetOwner o where o.id in :ids" )
    List<PetOwner> findByPetOwnerIds(@Param("ids") List<Integer> petOwnerIds);
}
