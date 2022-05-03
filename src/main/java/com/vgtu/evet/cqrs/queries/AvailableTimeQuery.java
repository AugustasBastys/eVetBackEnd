package com.vgtu.evet.cqrs.queries;

import com.vgtu.evet.entities.vetServices.AvailableTime;
import com.vgtu.evet.repository.AvailableTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AvailableTimeQuery {

    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    public List<AvailableTime> getTimesByVeterinarian(int id) {
       return availableTimeRepository.findByBookedFalseAndVeterinarianId(id);
    }

    public List<AvailableTime> getTimesByService(int id) {
        return availableTimeRepository.findAllTimesByServiceIdAndIsNotBooked(id);
    }
}
