package com.vgtu.evet.repository;

import com.vgtu.evet.entities.vetServices.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Integer> {
    List<AvailableTime> findByVeterinarianId(int id);

    @Query("SELECT a FROM AvailableTime a, Veterinarian v where v.vetService.id = :serviceId AND a.veterinarian.id = v.id" +
            " and a.booked = false")
    List<AvailableTime> findAllTimesByServiceIdAndIsNotBooked(@Param("serviceId") int id);
}
