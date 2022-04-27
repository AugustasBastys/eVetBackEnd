package com.vgtu.evet.cqrs.commands;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdatePetCommand {

    private int id;
    private String name;
    private String color;
    private boolean sterilized;
    private boolean hidden;

}
