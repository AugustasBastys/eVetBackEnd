package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.vetServices.VetService;
import com.vilniustech.evet.repository.VetServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VetServiceQuery {

    @Autowired
    private VetServiceRepository vetServiceRepository;

    public List<VetService> getVetServices() {
        return vetServiceRepository.findAll();
    }
}
