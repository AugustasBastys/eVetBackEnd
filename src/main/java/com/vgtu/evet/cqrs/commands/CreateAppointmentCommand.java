package com.vgtu.evet.cqrs.commands;

import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.entities.vetServices.AvailableTime;
import com.vgtu.evet.entities.vetServices.VetService;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAppointmentCommand {

//    private int vetServiceId;
//    private int availableTimeId;
//    private int petId;
//    private String ownersComment;

    private VetService vetService;
    private AvailableTime availableTime;
    private String ownersComment;
    private Pet pet;
}
