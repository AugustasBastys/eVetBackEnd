package com.vgtu.evet.cqrs.aggregates;

import com.vgtu.evet.cqrs.commands.CreatePetCommand;
import com.vgtu.evet.cqrs.commands.UpdatePetCommand;
import com.vgtu.evet.entities.petRecords.PetRecord;
import com.vgtu.evet.entities.pets.OwnedPet;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.repository.OwnedPetRepository;
import com.vgtu.evet.repository.PetOwnerRepository;
import com.vgtu.evet.repository.PetRecordRepository;
import com.vgtu.evet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetAggregate {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetOwnerRepository petOwnerRepository;

    @Autowired
    private OwnedPetRepository ownedPetRepository;

    @Autowired
    private PetRecordRepository petRecordRepository;

    public Pet handleCreatePetCommand(CreatePetCommand petCommand, String ownerId) {

        Pet pet = Pet.builder()
                .birthday(petCommand.getBirthDay())
                .breed(petCommand.getBreed())
                .color(petCommand.getColor())
                .gender(petCommand.getGenderType())
                .name(petCommand.getName())
                .sterilized(petCommand.isSterilized())
                .build();

       petRepository.save(pet);

       ownedPetRepository.save(OwnedPet.builder().petOwner(ownerId).pet(pet).build());

       petRecordRepository.save(PetRecord.builder().pet(pet).build());

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
        if(updatePetCommand.getBirthday() != null) {
            pet.setBirthday(updatePetCommand.getBirthday());
        }
        pet.setHidden(updatePetCommand.isHidden());


        petRepository.save(pet);

        return pet;
    }

}
