package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.vetServices.Veterinarian;
import com.vilniustech.evet.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VeterinarianQuery {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public List<Veterinarian> getVeterinarians() {
        return veterinarianRepository.findAll();
    }

    public Veterinarian getVeterinarian(int id) {
        return veterinarianRepository.findById(id).orElse(null);
    }

    public List<Veterinarian> getVeterinariansByService(int id) {
        return veterinarianRepository.findByVetServiceId(id);
    }
}
