package com.vgtu.evet.cqrs.commands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAppointmentCommand {
    private int id;
    private boolean canceled;
    private String ownersComment;
}
