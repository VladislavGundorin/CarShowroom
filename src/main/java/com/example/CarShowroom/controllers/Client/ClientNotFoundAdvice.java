package com.example.CarShowroom.controllers.Client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ClientNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ClientNotFoundException(ClientNotFoundException exception){
        return exception.getMessage();
    }
}
