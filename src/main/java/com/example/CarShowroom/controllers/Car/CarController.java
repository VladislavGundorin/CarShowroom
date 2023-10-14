package com.example.CarShowroom.controllers.Car;

import com.example.CarShowroom.dtos.CarDto;
import com.example.CarShowroom.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }


    @GetMapping("/cars/{id}")
    public CarDto getCarById(@PathVariable int id) {
        return carService.getCarById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    @PostMapping("/cars")
    public CarDto createCar(@RequestBody CarDto carDto) {
        return carService.createCar(carDto);
    }

    @PutMapping("/cars/{id}")
    public CarDto updateCar(@PathVariable int id, @RequestBody CarDto carDto) {
        carDto.setId(id);
        return carService.updateCar(carDto);
    }
    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }


    @GetMapping("/cars/transmission/{transmissionType}")
    public List<CarDto> findAllCarsWithAutomaticTransmission(@PathVariable String transmissionType) {
        return carService.findAllCarsWithAutomaticTransmission(transmissionType);
    }
}
