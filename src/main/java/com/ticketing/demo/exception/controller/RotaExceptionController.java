package com.ticketing.demo.exception.controller;

import com.ticketing.demo.exception.RotaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RotaExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = RotaNotFoundException.class)
    public ResponseEntity<Object> exception(RotaNotFoundException exception){
        return new ResponseEntity<>("Rota not found!", HttpStatus.NOT_FOUND);
    }
}
