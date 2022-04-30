package com.vgtu.evet.cqrs.commands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelAppointmentCommand {
    private int id;
    private boolean cancel;
}
