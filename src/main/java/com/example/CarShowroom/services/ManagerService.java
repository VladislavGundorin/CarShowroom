package com.example.CarShowroom.services;

import com.example.CarShowroom.dtos.ManagerDto;
import com.example.CarShowroom.models.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    ManagerDto createManager(ManagerDto managerDto);

    Optional<ManagerDto> getManagerById(int id);

    List<ManagerDto> getAllManagers();

    ManagerDto updateManager(ManagerDto managerDto);

    void deleteManager(int id);

    List <ManagerDto> findAllByOrderByNameBadgeAsc ();

    List <ManagerDto> findNumberOfRegularClientsByManagerId(int managerId);
}