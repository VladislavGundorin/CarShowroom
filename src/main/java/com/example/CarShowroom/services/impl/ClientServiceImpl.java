package com.example.CarShowroom.services.impl;

import com.example.CarShowroom.dtos.ClientDto;
import com.example.CarShowroom.models.Car;
import com.example.CarShowroom.models.Client;
import com.example.CarShowroom.repositories.ClientRepository;
import com.example.CarShowroom.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        return modelMapper.map(clientRepository.save(client), ClientDto.class);
    }

    @Override
    public Optional<ClientDto> getClientById(int id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.map(client -> modelMapper.map(client, ClientDto.class));
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        return modelMapper.map(clientRepository.save(client), ClientDto.class);
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDto> findClientsByClientStatus(String status) {
        List<Client> clients = clientRepository.findClientsByClientStatus(status);
        return clients.stream()
                .map(client -> modelMapper.map(client, ClientDto.class))
                .collect(Collectors.toList());
    }
}