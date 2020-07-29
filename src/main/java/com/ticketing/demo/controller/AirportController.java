package com.ticketing.demo.controller;

import com.ticketing.demo.dao.AirportDao;
import com.ticketing.demo.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing")
public class AirportController {
    @Autowired
    AirportDao airportDao;

    @PostMapping("/airports")
    public Airport createAirport(@Validated @RequestBody Airport airport){
        return airportDao.save(airport);
    }

    @GetMapping("/airports")
    public List<Airport> getAllAirports(){
        return airportDao.findAll();
    }

    @GetMapping("/airports/{airportId}")
    public ResponseEntity<Airport> getAirportById(@PathVariable(value = "airportId") Long airportId){
        Airport airport = airportDao.findOne(airportId);
        if(airport == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(airport);
    }
    @PutMapping("/airports/{airportId}")
    public ResponseEntity<Airport> updateAirport(@PathVariable(value = "airportId") Long airportId, @Validated @RequestBody Airport airportDetails){
        Airport airport = airportDao.findOne(airportId);
        if (airport == null){
            return ResponseEntity.notFound().build();
        }
        airport.setAirportName(airportDetails.getAirportName());
        Airport updateAirport = airportDao.save(airport);
        return ResponseEntity.ok().body(updateAirport);
    }

    @DeleteMapping("/airports/{airportId}")
    public ResponseEntity<Airport> deleteAirport(@PathVariable(value = "airportId") Long airportId){
        Airport airport = airportDao.findOne(airportId);
        if (airport == null){
            return ResponseEntity.notFound().build();
        }
        airportDao.delete(airport);
        return ResponseEntity.ok().build();
    }
}
