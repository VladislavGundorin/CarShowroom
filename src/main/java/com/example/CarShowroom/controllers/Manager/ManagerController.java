package com.example.CarShowroom.controllers.Manager;

import com.example.CarShowroom.dtos.CarDto;
import com.example.CarShowroom.dtos.ManagerDto;
import com.example.CarShowroom.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService manangerService) {
        this.managerService = manangerService;
    }

    @GetMapping("/managers")
    public List<ManagerDto> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/managers/{id}")
    public ManagerDto getManagerById(@PathVariable int id) {
        return managerService.getManagerById(id).orElseThrow(() -> new ManagerNotFoundException(id));
    }

    @PostMapping("/managers")
    public ManagerDto createManager(@RequestBody ManagerDto managerDto) {
        return managerService.createManager(managerDto);
    }

    @PutMapping("/managers/{id}")
    public ManagerDto updateManager(@PathVariable int id, @RequestBody ManagerDto managerDto) {
        managerDto.setId(id);
        return managerService.updateManager(managerDto);
    }

    @DeleteMapping("/managers/{id}")
    public void deleteManager(@PathVariable int id) {
        managerService.deleteManager(id);
    }

    @GetMapping("/managers/sorted")
    public List<ManagerDto> findAllByOrderByNameBadgeAsc() {
        return managerService.findAllByOrderByNameBadgeAsc();
    }

    @GetMapping("/managers/regularclients/{managerID}")
    public List<ManagerDto> findNumberOfRegularClientsByManagerId(@PathVariable int managerID) {
        return managerService.findNumberOfRegularClientsByManagerId(managerID);
    }
}