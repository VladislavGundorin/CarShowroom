package com.example.CarShowroom.repositories;

import com.example.CarShowroom.dtos.ClientDto;
import com.example.CarShowroom.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {
    List<Client> findClientsByClientStatus(String status);

    Client findClientById(Integer clientId);
}
