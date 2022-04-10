package com.vgtu.evet.controller;

import com.vgtu.evet.cqrs.aggregates.PetAggregate;
import com.vgtu.evet.cqrs.commands.CreatePetCommand;
import com.vgtu.evet.cqrs.commands.UpdatePetCommand;
import com.vgtu.evet.cqrs.queries.PetQuery;
import com.vgtu.evet.entities.pets.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetAggregate petAggregate;

    @Autowired
    private PetQuery petQuery;

//    @PreAuthorize("hasAuthority('SCOPE_Test-API')")
    @ResponseBody
    @PostMapping("/create")
    public Pet createPet(@RequestBody CreatePetCommand petCommand) {
        return petAggregate.handleCreatePetCommand(petCommand);
    }

    @ResponseBody
    @PutMapping("/update")
    public Pet updatePet(@RequestBody UpdatePetCommand petCommand) {
        return petAggregate.handleUpdatePetCommand(petCommand);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Pet getPet(@PathVariable int id) {
        return petQuery.getById(id);
    }

    @ResponseBody
    @GetMapping("/owner/{ownerId}")
    public List<Pet> getPetsOfOwner(@PathVariable int ownerId) {
        return petQuery.getByOwnersId(ownerId);
    }

}
