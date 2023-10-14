package com.example.CarShowroom.controllers.Client;

import com.example.CarShowroom.dtos.ClientDto;
import com.example.CarShowroom.models.Client;
import com.example.CarShowroom.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientDto> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("clients/{id}")
    public ClientDto getClientById(@PathVariable int id) {
        return clientService.getClientById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    @PostMapping("/clients")
    public ClientDto createClient(@RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @PutMapping("/clients/{id}")
    public ClientDto updateClient(@PathVariable int id, @RequestBody ClientDto clientDto) {
        clientDto.setId(id);
        return clientService.updateClient(clientDto);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/clients/status/{status}")
    public List<ClientDto> findClientsByClientStatus(@PathVariable String status) {
        return clientService.findClientsByClientStatus(status);
    }
}
