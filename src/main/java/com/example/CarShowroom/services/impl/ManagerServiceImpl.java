package com.example.CarShowroom.services.impl;

import com.example.CarShowroom.dtos.ManagerDto;
import com.example.CarShowroom.models.Manager;
import com.example.CarShowroom.repositories.ManagerRepository;
import com.example.CarShowroom.services.ManagerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private final ManagerRepository managerRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository, ModelMapper modelMapper) {
        this.managerRepository = managerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ManagerDto createManager(ManagerDto managerDto) {
        Manager manager = modelMapper.map(managerDto, Manager.class);
        return modelMapper.map(managerRepository.save(manager), ManagerDto.class);
    }

    @Override
    public Optional<ManagerDto> getManagerById(int id) {
        Optional<Manager> optionalManager = managerRepository.findById(id);
        return optionalManager.map(manager -> modelMapper.map(manager, ManagerDto.class));
    }


    @Override
    public List<ManagerDto> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return managers.stream()
                .map(manager -> modelMapper.map(manager, ManagerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ManagerDto updateManager(ManagerDto managerDto) {
        Manager manager = modelMapper.map(managerDto, Manager.class);
        return modelMapper.map(managerRepository.save(manager), ManagerDto.class);
    }

    @Override
    public void deleteManager(int id) {
        managerRepository.deleteById(id);
    }

    @Override
    public List<ManagerDto> findAllByOrderByNameBadgeAsc() {
        List<Manager> managers = managerRepository.findAllByOrderByNameBadgeAsc();
        return managers.stream()
                .map(manager -> modelMapper.map(manager, ManagerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ManagerDto> findNumberOfRegularClientsByManagerId(int managerId) {
        int numberOfRegularClients = managerRepository.findNumberOfRegularClientsByManagerId(managerId);
        List<ManagerDto> allManagers = getAllManagers(); // Метод getAllManagers() должен быть реализован в ManagerServiceImpl

        // Фильтруем список всех менеджеров по идентификатору, чтобы оставить только нужного менеджера
        List<ManagerDto> filteredManagers = allManagers.stream()
                .filter(manager -> manager.getId() == managerId)
                .collect(Collectors.toList());

        // Если менеджер с таким идентификатором найден, обновляем у него количество постоянных клиентов
        if (!filteredManagers.isEmpty()) {
            ManagerDto managerToUpdate = filteredManagers.get(0);
            managerToUpdate.setNumberOfClients(numberOfRegularClients);
        }

        return allManagers;
    }

}