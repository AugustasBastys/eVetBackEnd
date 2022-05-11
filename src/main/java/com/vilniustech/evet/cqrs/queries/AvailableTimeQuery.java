package com.vilniustech.evet.cqrs.queries;

import com.vilniustech.evet.entities.vetServices.AvailableTime;
import com.vilniustech.evet.repository.AvailableTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvailableTimeQuery {

    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    public List<AvailableTime> getTimesByVeterinarian(int id) {
       return availableTimeRepository.findByBookedFalseAndVeterinarianIdOrderByDateAsc(id);
    }

    public List<AvailableTime> getTimesByService(int id) {
        return availableTimeRepository.findAllTimesByServiceIdAndIsNotBooked(id);
    }
}
