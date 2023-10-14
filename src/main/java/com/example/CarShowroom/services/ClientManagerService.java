package com.example.CarShowroom.services;

import com.example.CarShowroom.dtos.CarKomplektatsiyaDto;
import com.example.CarShowroom.dtos.ClientManagerDto;
import com.example.CarShowroom.dtos.ManagerDto;

import java.util.List;

public interface ClientManagerService <ID>{
    List<ClientManagerDto> getAll();

    ClientManagerDto addManagerToClient(Integer clientId, Integer managerId);


}
