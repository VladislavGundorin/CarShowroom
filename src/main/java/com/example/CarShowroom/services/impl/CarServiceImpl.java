package com.example.CarShowroom.services.impl;


import com.example.CarShowroom.dtos.CarDto;
import com.example.CarShowroom.models.Car;
import com.example.CarShowroom.repositories.CarRepository;
import com.example.CarShowroom.services.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private final CarRepository carRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);
        return modelMapper.map(carRepository.save(car), CarDto.class);
    }

    @Override
    public Optional<CarDto> getCarById(int id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(car -> modelMapper.map(car, CarDto.class));
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarDto updateCar(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);
        return modelMapper.map(carRepository.save(car), CarDto.class);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }


    @Override
    public List<CarDto> findCarsByYearOfReleaseGreaterThan(int yearOfRelease) {
        List<Car> cars = carRepository.findCarsByYearOfReleaseGreaterThan(yearOfRelease);
        return cars.stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> findCarsByTypeOfBody(String typeOfBody) {
        List<Car> cars = carRepository.findCarsByTypeOfBody(typeOfBody);
        return cars.stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> findAllCarsWithAutomaticTransmission(String transmissionType) {
        List<Car> cars = carRepository.findAllCarsWithAutomaticTransmission(transmissionType);
        return cars.stream()
                .map(car -> modelMapper.map(car, CarDto.class))
                .collect(Collectors.toList());
    }

}


