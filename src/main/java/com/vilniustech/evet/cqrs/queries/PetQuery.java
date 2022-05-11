package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.pets.OwnedPet;
import com.vilniustech.evet.entities.pets.Pet;
import com.vilniustech.evet.repository.OwnedPetRepository;
import com.vilniustech.evet.repository.PetRepository;
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

        return pet;
    }

    public List<Pet> getByOwnersId(String ownersId) {
        List<OwnedPet> ownedPets = ownedPetRepository.findAllOwnedPetsByUserId(ownersId);

        List<Pet> pets = new ArrayList<>();
        Pet pet;

        for(OwnedPet ownedPet: ownedPets) {
            pet = petRepository.findById(ownedPet.getPet().getId()).orElse(null);
            pets.add(pet);
        }

        return pets;
    }
}
