package com.vgtu.evet.cqrs.commands;

import com.vgtu.evet.entities.pets.BreedType;
import com.vgtu.evet.entities.pets.GenderType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CreatePetCommand {
    private String name;
    private String color;
    private Date birthDay;
    private GenderType genderType;
    private boolean sterilized;
    private BreedType breed;
    private List<Integer> petOwnerIds;
}
