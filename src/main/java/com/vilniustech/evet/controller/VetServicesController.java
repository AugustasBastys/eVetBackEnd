package com.vilniustech.evet.controller;

import com.vilniustech.evet.cqrs.queries.VetServiceQuery;
import com.vilniustech.evet.entities.vetServices.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vetServices")
@CrossOrigin(origins = "http://localhost:3000/")
public class VetServicesController {

    @Autowired
    private VetServiceQuery vetServiceQuery;

    @ResponseBody
    @GetMapping
    public List<VetService> getVetServices() {
        return vetServiceQuery.getVetServices();
    }

}
