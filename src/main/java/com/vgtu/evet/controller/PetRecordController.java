package com.vgtu.evet.controller;

import com.vgtu.evet.cqrs.queries.PetRecordQuery;
import com.vgtu.evet.entities.petRecords.PetRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class PetRecordController {

    @Autowired
    private PetRecordQuery petRecordQuery;

    @ResponseBody
    @GetMapping("/{id}")
    public PetRecord getPetRecordById(@PathVariable int id) {
        return petRecordQuery.getByRecordId(id);
    }

    @ResponseBody
    @GetMapping("/pet/{id}")
    public PetRecord getPetRecordByPetId(@PathVariable int id) {
        return petRecordQuery.getByRecordPetId(id);
    }

}
