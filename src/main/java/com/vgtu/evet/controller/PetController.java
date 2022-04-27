package com.vgtu.evet.controller;

import com.vgtu.evet.cqrs.aggregates.PetAggregate;
import com.vgtu.evet.cqrs.commands.CreatePetCommand;
import com.vgtu.evet.cqrs.commands.UpdatePetCommand;
import com.vgtu.evet.cqrs.queries.PetQuery;
import com.vgtu.evet.entities.pets.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:3000/")
public class PetController {

    @Autowired
    private PetAggregate petAggregate;

    @Autowired
    private PetQuery petQuery;

//    @PreAuthorize("hasAuthority('SCOPE_Test-API')")
    @ResponseBody
    @PostMapping("/create")
    public Pet createPet(@RequestBody CreatePetCommand petCommand) {
        return petAggregate.handleCreatePetCommand(petCommand, SecurityContextHolder.getContext().
                getAuthentication().getName());
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
    @GetMapping
    public List<Pet> getPets() {
        return petQuery.getByOwnersId(SecurityContextHolder.getContext().
                getAuthentication().getName());
    }

}
