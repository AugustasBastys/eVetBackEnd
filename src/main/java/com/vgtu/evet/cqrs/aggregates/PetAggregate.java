package com.vgtu.evet.cqrs.aggregates;

import com.vgtu.evet.cqrs.commands.CreatePetCommand;
import com.vgtu.evet.cqrs.commands.UpdatePetCommand;
import com.vgtu.evet.entities.pets.OwnedPet;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.entities.pets.PetOwner;
import com.vgtu.evet.repository.OwnedPetRepository;
import com.vgtu.evet.repository.PetOwnerRepository;
import com.vgtu.evet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PetAggregate {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @Autowired
    private OwnedPetRepository ownedPetRepository;

    public Pet handleCreatePetCommand(CreatePetCommand petCommand) {

        Pet pet = Pet.builder()
                .birthday(petCommand.getBirthDay())
                .breed(petCommand.getBreed())
                .color(petCommand.getColor())
                .gender(petCommand.getGenderType())
                .name(petCommand.getName())
                .sterilized(petCommand.isSterilized())
                .build();

       petRepository.save(pet);

       savePetAndPetOwnerRelationship(petCommand.getPetOwnerIds(), pet);

       return pet;
    }

    public Pet handleUpdatePetCommand(UpdatePetCommand updatePetCommand) {
        Pet pet = petRepository.findById(updatePetCommand.getId()).orElse(null);

        if(updatePetCommand.getColor() != null) {
            pet.setColor(updatePetCommand.getColor());
        }
        if(updatePetCommand.isSterilized()) {
            pet.setSterilized(true);
        }
        if(updatePetCommand.getName() != null) {
            pet.setName(updatePetCommand.getName());
        }
        if(updatePetCommand.isHidden()) {
            pet.setHidden(true);
        }
        if(updatePetCommand.getPetOwnerIds() != null) {
            savePetAndPetOwnerRelationship(updatePetCommand.getPetOwnerIds(), pet);
        }

        return petRepository.save(pet);
    }

    private void savePetAndPetOwnerRelationship(List<Integer> ownerIds, Pet pet) {
        List<PetOwner> petOwners = new ArrayList<>();
        ownerIds.forEach( id -> {
            petOwners.add( petOwnerRepository.findById(id).orElse(null));
        } );

        petOwners.forEach( petOwner -> {
            ownedPetRepository.save(OwnedPet.builder().petOwner(petOwner).pet(pet).build());
        });
    }

}
