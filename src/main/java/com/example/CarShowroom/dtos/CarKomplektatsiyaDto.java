package com.example.CarShowroom.dtos;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;


public class CarKomplektatsiyaDto {
    private CarDto car;

    private KomplektatsiyaDto komplektatsiya;

    public CarKomplektatsiyaDto(CarDto car, KomplektatsiyaDto komplektatsiya) {
        this.car = car;
        this.komplektatsiya = komplektatsiya;
    }

    public CarKomplektatsiyaDto() {
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public KomplektatsiyaDto getKomplektatsiya() {
        return komplektatsiya;
    }

    public void setKomplektatsiya(KomplektatsiyaDto komplektatsiya) {
        this.komplektatsiya = komplektatsiya;
    }

    @Override
    public String toString() {
        return "CarKomplektatsiyaDto{" +
                "car=" + car +
                ", komplektatsiya=" + komplektatsiya +
                '}';
    }
}
