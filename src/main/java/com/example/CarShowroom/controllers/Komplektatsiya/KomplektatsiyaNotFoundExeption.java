package com.example.CarShowroom.controllers.Komplektatsiya;

public class KomplektatsiyaNotFoundExeption extends RuntimeException{
    public KomplektatsiyaNotFoundExeption(int id) {
        super("Комплектации нет с таким id: " + id);
    }
}
