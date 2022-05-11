package com.vilniustech.evet.cqrs.commands;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class UpdatePetCommand {

    private int id;
    private String name;
    private String color;
    private boolean sterilized;
    private boolean hidden;
    private Date birthday;

}
