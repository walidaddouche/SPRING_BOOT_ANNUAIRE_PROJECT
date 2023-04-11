package com.example.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Throwable.class)
    public String handleException(Throwable e) {
        // Gérer l'exception ici
        return "error";
    }
}
