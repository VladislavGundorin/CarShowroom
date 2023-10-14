package com.example.CarShowroom.repositories;

import com.example.CarShowroom.models.ClientManager;
import com.example.CarShowroom.models.ClientManagerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientManagerRepository extends JpaRepository<ClientManager, ClientManagerId> {

}
