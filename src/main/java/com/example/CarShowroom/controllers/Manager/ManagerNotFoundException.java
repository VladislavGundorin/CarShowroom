package com.example.CarShowroom.controllers.Manager;

public class ManagerNotFoundException extends RuntimeException {
    public ManagerNotFoundException(int id) {
        super("Менеджер нет с таким id: " + id);
    }
}