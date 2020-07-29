package com.ticketing.demo.exception.controller;

import com.ticketing.demo.exception.AirportNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AirportExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = AirportNotFoundException.class)
    public ResponseEntity<Object> exception(AirportNotFoundException exception){
        return new ResponseEntity<>("Airport not found!", HttpStatus.NOT_FOUND);
    }

}
