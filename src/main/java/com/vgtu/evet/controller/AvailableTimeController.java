package com.vgtu.evet.controller;

import com.vgtu.evet.cqrs.queries.AvailableTimeQuery;
import com.vgtu.evet.entities.vetServices.AvailableTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/availableTimes")
@CrossOrigin(origins = "http://localhost:3000/")
public class AvailableTimeController {

    @Autowired
    private AvailableTimeQuery availableTimeQuery;

    @ResponseBody
    @GetMapping("/veterinarian/{id}")
    public List<AvailableTime> getTimesByVeterinarian(@PathVariable int id) {
        return availableTimeQuery.getTimesByVeterinarian(id);
    }

    @ResponseBody
    @GetMapping("/service/{id}")
    public List<AvailableTime> getTimesByService(@PathVariable int id) {
        return availableTimeQuery.getTimesByService(id);
    }
}
