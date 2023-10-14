package com.example.CarShowroom.services;

import com.example.CarShowroom.dtos.CarDto;
import com.example.CarShowroom.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    CarDto createCar(CarDto carDto); // Изменяем тип параметра и возвращаемого значения на CarDto

    Optional<CarDto> getCarById(int id); // Изменяем возвращаемый тип на Optional<CarDto>

    List<CarDto> getAllCars(); // Изменяем тип возвращаемого списка на List<CarDto>

    CarDto updateCar(CarDto carDto); // Изменяем тип параметра и возвращаемого значения на CarDto

    void deleteCar(int id);

    List<CarDto> findCarsByYearOfReleaseGreaterThan(int yearOfRelease);

    List<CarDto> findCarsByTypeOfBody(String typeOfBody);

    List<CarDto> findAllCarsWithAutomaticTransmission(String transmissionType);

}




