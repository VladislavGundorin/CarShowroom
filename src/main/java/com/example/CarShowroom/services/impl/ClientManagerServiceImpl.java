package com.example.CarShowroom.services.impl;

import com.example.CarShowroom.dtos.ClientManagerDto;
import com.example.CarShowroom.dtos.ManagerDto;
import com.example.CarShowroom.models.Client;
import com.example.CarShowroom.models.ClientManager;
import com.example.CarShowroom.models.Manager;
import com.example.CarShowroom.repositories.ClientManagerRepository;
import com.example.CarShowroom.repositories.ClientRepository;
import com.example.CarShowroom.repositories.ManagerRepository;
import com.example.CarShowroom.services.ClientManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientManagerServiceImpl implements ClientManagerService {

    @Autowired
    private ClientManagerRepository clientManagerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public List<ClientManagerDto> getAll() {
        return clientManagerRepository.findAll().stream()
                .map(clientManager -> modelMapper.map(clientManager, ClientManagerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientManagerDto addManagerToClient(Integer managerId, Integer clientId) {
        Manager manager = managerRepository.findManagerById(managerId);
        Client client = clientRepository.findClientById(clientId);

        ClientManager clientManager = new ClientManager(client, manager);
        clientManagerRepository.save(clientManager);
        return modelMapper.map(clientManager, ClientManagerDto.class);
    }

}
