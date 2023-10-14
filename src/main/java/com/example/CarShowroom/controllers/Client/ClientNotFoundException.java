package com.example.CarShowroom.controllers.Client;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(int id) {
        super("Клиента нет с таким id: " + id);
    }
}
