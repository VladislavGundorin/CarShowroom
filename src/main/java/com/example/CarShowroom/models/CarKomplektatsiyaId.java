package com.example.CarShowroom.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;


public class CarKomplektatsiyaId implements Serializable {
    private Car car;

    private Komplektatsiya komplektatsiya;

    public CarKomplektatsiyaId(Car car, Komplektatsiya komplektatsiya) {
        this.car = car;
        this.komplektatsiya = komplektatsiya;
    }

    public CarKomplektatsiyaId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarKomplektatsiyaId that)) return false;
        return Objects.equals(car, that.car) && Objects.equals(komplektatsiya, that.komplektatsiya);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, komplektatsiya);
    }
}
