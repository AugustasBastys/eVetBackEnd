package com.vgtu.evet.controller;

import com.vgtu.evet.cqrs.commands.CreatePetCommand;
import com.vgtu.evet.cqrs.queries.VetServiceQuery;
import com.vgtu.evet.entities.pets.Pet;
import com.vgtu.evet.entities.vetServices.VetService;
import com.vgtu.evet.repository.VetServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetServises")
public class VetServicesController {

    @Autowired
    private VetServiceQuery vetServiceQuery;

    @ResponseBody
    @GetMapping
    public List<VetService> getVetServices() {
        return vetServiceQuery.getVetServices();
    }

}
