package com.vgtu.evet.cqrs.queries;

import com.vgtu.evet.entities.pets.OwnedPet;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.repository.OwnedPetRepository;
import com.vgtu.evet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetQuery {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnedPetRepository ownedPetRepository;

    public Pet getById(int id) {
        Pet pet = petRepository.findById(id).orElse(null);
        if(pet.isHidden()) {
            return null;
        }
        return pet;
    }

    public List<Pet> getByOwnersId(int ownerId) {
        List<OwnedPet> ownedPets = ownedPetRepository.findAllOwnedPetsByUserId(ownerId);

        List<Pet> pets = new ArrayList<>();
        Pet pet;

        for(OwnedPet ownedPet: ownedPets) {
            pet = petRepository.findById(ownedPet.getPet().getId()).orElse(null);
            if(!pet.isHidden()) {
                pets.add(pet);
            }
        }

        return pets;
    }
}
