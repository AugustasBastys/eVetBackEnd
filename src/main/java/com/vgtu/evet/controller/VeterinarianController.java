package com.vgtu.evet.controller;

import com.vgtu.evet.cqrs.queries.VeterinarianQuery;
import com.vgtu.evet.entities.vetServices.Veterinarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarians")
@CrossOrigin(origins = "http://localhost:3000/")
public class VeterinarianController {

    @Autowired
    private VeterinarianQuery veterinarianQuery;

    @ResponseBody
    @GetMapping
    public List<Veterinarian> getVeterinarians() {
        return veterinarianQuery.getVeterinarians();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Veterinarian getVeterinarian(@PathVariable int id) {
        return veterinarianQuery.getVeterinarian(id);
    }

    @ResponseBody
    @GetMapping("/service/{id}")
    public List<Veterinarian> getVeterinarians(@PathVariable int id) {
        return veterinarianQuery.getVeterinariansByService(id);
    }



}
