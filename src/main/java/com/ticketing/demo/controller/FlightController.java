package com.ticketing.demo.controller;

import com.ticketing.demo.dao.FlightDao;
import com.ticketing.demo.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing")
public class FlightController {
    @Autowired
    FlightDao flightDao;

    @PostMapping("/flights")
    public ResponseEntity<Flight> createFlight(@Validated @RequestBody Flight flight){
        flightDao.save(flight);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/flights")
    public List<Flight> getAllFlights(){
        return  flightDao.findAll();
    }

    @GetMapping("/flights/{flightId}")
    public ResponseEntity<Flight> getFlightById(@PathVariable(value = "flightId") Long flightId){
        Flight flight = flightDao.findOne(flightId);
        return ResponseEntity.ok().body(flight);
    }

    @PutMapping("flights/{flightId}")
    public ResponseEntity<Flight> updateFlight(@PathVariable(value = "flightId") Long flightId, @Validated @RequestBody Flight flightDetails){
        Flight flight = flightDao.findOne(flightId);
        flight.setDate(flightDetails.getDate());
        flight.setQuota(flightDetails.getQuota());
        flight.setRota(flightDetails.getRota());
        Flight updateFlight = flightDao.save(flight);
        return ResponseEntity.ok().body(updateFlight);
    }

    @DeleteMapping("flights/{flightId}")
    public ResponseEntity<Flight> deleteFlight(@PathVariable(value = "flightId") Long flightId){
        Flight flight = flightDao.findOne(flightId);
        flightDao.delete(flight);
        return ResponseEntity.ok().build();
    }
}
