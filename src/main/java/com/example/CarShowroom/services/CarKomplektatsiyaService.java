package com.example.CarShowroom.services;

import com.example.CarShowroom.dtos.CarKomplektatsiyaDto;

import java.util.List;

public interface CarKomplektatsiyaService<ID> {

    List<CarKomplektatsiyaDto> getAll();

    CarKomplektatsiyaDto addCarToKomplektatsiya(Integer carId, Integer komplektatsiyaId);
}
