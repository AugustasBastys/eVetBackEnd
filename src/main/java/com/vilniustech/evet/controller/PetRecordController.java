package com.vilniustech.evet.controller;

import com.vilniustech.evet.cqrs.queries.PetRecordQuery;
import com.vilniustech.evet.entities.petRecords.PetRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = "http://localhost:3000/")
public class PetRecordController {

    @Autowired
    private PetRecordQuery petRecordQuery;

    @ResponseBody
    @GetMapping("/pet/{id}")
    public PetRecord getPetRecordByPetId(@PathVariable int id) {
        return petRecordQuery.getByRecordPetId(id);
    }

}
