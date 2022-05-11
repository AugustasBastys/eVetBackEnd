package com.vilniustech.evet.repository;

import com.vilniustech.evet.entities.vetServices.AvailableTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Integer> {
    List<AvailableTime> findByBookedFalseAndVeterinarianIdOrderByDateAsc(int id);

    @Query("SELECT a FROM AvailableTime a, Veterinarian v where v.vetService.id = :serviceId AND a.veterinarian.id = v.id AND a.booked = false" +
            " order by a.date asc")
    List<AvailableTime> findAllTimesByServiceIdAndIsNotBooked(@Param("serviceId") int id);
}
