package com.vilniustech.evet.controller;

import com.vilniustech.evet.cqrs.aggregates.PetAggregate;
import com.vilniustech.evet.cqrs.commands.CreatePetCommand;
import com.vilniustech.evet.cqrs.commands.UpdatePetCommand;
import com.vilniustech.evet.cqrs.queries.PetQuery;
import com.vilniustech.evet.entities.pets.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@CrossOrigin(originPatterns = "http://localhost:3000/")
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
