package com.example.CarShowroom.services;

import com.example.CarShowroom.dtos.ClientDto;
import com.example.CarShowroom.models.Car;
import com.example.CarShowroom.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    ClientDto createClient(ClientDto clientDto);

    Optional<ClientDto> getClientById(int id);

    List<ClientDto> getAllClients();

    ClientDto updateClient(ClientDto clientDto);

    void deleteClient(int id);

    List<ClientDto> findClientsByClientStatus(String status);
}
