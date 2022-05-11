package com.vilniustech.evet.cqrs.commands;

import com.vilniustech.evet.entities.pets.BreedType;
import com.vilniustech.evet.entities.pets.GenderType;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreatePetCommand {
    private String name;
    private String color;
    private Date birthDay;
    private GenderType genderType;
    private boolean sterilized;
    private BreedType breed;
}
