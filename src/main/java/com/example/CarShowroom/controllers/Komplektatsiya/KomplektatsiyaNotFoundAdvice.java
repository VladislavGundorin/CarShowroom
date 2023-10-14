package com.example.CarShowroom.controllers.Komplektatsiya;

import com.example.CarShowroom.controllers.Client.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class KomplektatsiyaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(KomplektatsiyaNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String KomplektatsiyaNotFoundException(KomplektatsiyaNotFoundExeption exception){
        return exception.getMessage();
    }
}
