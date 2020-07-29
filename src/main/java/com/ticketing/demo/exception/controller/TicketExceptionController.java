package com.ticketing.demo.exception.controller;

import com.ticketing.demo.exception.TicketNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TicketExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = TicketNotFoundException.class)
    public ResponseEntity<Object> exception(TicketNotFoundException exception){
        return new ResponseEntity<>("Ticket not found!", HttpStatus.NOT_FOUND);
    }
}
