package com.ticketing.demo.exception.controller;

import com.ticketing.demo.exception.AirlineNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AirlineExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = AirlineNotFoundException.class)
    public ResponseEntity<Object> exception(AirlineNotFoundException exception){
        return new ResponseEntity<>("Airline not found!", HttpStatus.NOT_FOUND);
    }
}
