package com.vilniustech.evet.repository;

import com.vilniustech.evet.entities.vetServices.VetService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetServiceRepository extends JpaRepository<VetService, Integer> {
}
