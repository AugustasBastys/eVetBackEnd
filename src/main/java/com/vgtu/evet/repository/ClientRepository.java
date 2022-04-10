package com.vgtu.evet.repository;

import com.vgtu.evet.entities.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Integer> {

}
