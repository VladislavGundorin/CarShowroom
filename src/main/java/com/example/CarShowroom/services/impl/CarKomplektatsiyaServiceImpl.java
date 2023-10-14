package com.example.CarShowroom.services.impl;

import com.example.CarShowroom.dtos.CarKomplektatsiyaDto;
import com.example.CarShowroom.models.Car;
import com.example.CarShowroom.models.CarKomplektatsiya;
import com.example.CarShowroom.models.Komplektatsiya;
import com.example.CarShowroom.repositories.CarKomplektatsiyaRepository;
import com.example.CarShowroom.repositories.CarRepository;
import com.example.CarShowroom.repositories.KomplektatsiyaRepository;
import com.example.CarShowroom.services.CarKomplektatsiyaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarKomplektatsiyaServiceImpl implements CarKomplektatsiyaService<Integer> {

    @Autowired
    private CarKomplektatsiyaRepository carKomplektatsiyaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private KomplektatsiyaRepository komplektatsiyaRepository;

    @Override
    public List<CarKomplektatsiyaDto> getAll() {
        return carKomplektatsiyaRepository.findAll().stream()
                .map(carKomplektatsiya -> modelMapper.map(carKomplektatsiya, CarKomplektatsiyaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarKomplektatsiyaDto addCarToKomplektatsiya(Integer carId, Integer komplektatsiyaId) {
        Car car = carRepository.findCarById(carId);
        Komplektatsiya komplektatsiya = komplektatsiyaRepository.findKomplektatsiyaById(komplektatsiyaId);

        CarKomplektatsiya carKomplektatsiya = new CarKomplektatsiya(car,komplektatsiya);
        carKomplektatsiyaRepository.save(carKomplektatsiya);
        return modelMapper.map(carKomplektatsiya, CarKomplektatsiyaDto.class);
    }


}
