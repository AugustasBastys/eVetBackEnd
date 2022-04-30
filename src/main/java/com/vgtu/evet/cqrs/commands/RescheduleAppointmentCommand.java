package com.vgtu.evet.cqrs.commands;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RescheduleAppointmentCommand {

    private int id;
    private int availableTimeId;

}
