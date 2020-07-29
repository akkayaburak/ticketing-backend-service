package com.ticketing.demo.exception.controller;

import com.ticketing.demo.exception.FlightNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FlightExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = FlightNotFoundException.class)
    public ResponseEntity<Object> exception(FlightNotFoundException exception){
        return new ResponseEntity<>("Flight not found!", HttpStatus.NOT_FOUND);
    }
}
