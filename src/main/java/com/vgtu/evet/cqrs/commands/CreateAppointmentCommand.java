package com.vgtu.evet.cqrs.commands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateAppointmentCommand {

    private int vetServiceId;
    private int availableTimeId;
    private int petId;
    private String ownersComment;

}
