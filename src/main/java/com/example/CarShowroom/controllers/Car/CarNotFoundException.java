package com.example.CarShowroom.controllers.Car;

public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(int id) {
        super("Клиент не с таким id: " + id);
    }
}
