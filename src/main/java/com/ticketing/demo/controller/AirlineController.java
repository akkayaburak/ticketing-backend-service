package com.ticketing.demo.controller;

import com.ticketing.demo.dao.AirlineDao;
import com.ticketing.demo.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing")
public class AirlineController {
    @Autowired
    AirlineDao airlineDao;

    @PostMapping("/airlines")
    public Airline createAirline(@Validated @RequestBody Airline airline){
        return airlineDao.save(airline);
    }

    @GetMapping("/airlines")
    public List<Airline> getAllAirlines(){
        return airlineDao.findAll();
    }

    @GetMapping("/airlines/{airlineId}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable(value = "airlineId") Long airlineId){
        Airline airline = airlineDao.findOne(airlineId);
        if(airline == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(airline);
    }

    @PutMapping("/airlines/{airlineId}")
    public ResponseEntity<Airline> updateAirline(@PathVariable(value = "airlineId") Long airlineId, @Validated @RequestBody Airline airlineDetails){
        Airline airline = airlineDao.findOne(airlineId);
        if (airline == null){
            return ResponseEntity.notFound().build();
        }
        airline.setAirlineName(airlineDetails.getAirlineName());
        Airline updateAirline = airlineDao.save(airline);
        return ResponseEntity.ok().body(updateAirline);
    }

    @DeleteMapping("/airlines/{airlineId}")
    public ResponseEntity<Airline> deleteAirline(@PathVariable(value = "airlineId") Long airlineId){
        Airline airline = airlineDao.findOne(airlineId);
        if (airline == null){
            return ResponseEntity.notFound().build();
        }
        airlineDao.delete(airline);
        return ResponseEntity.ok().build();
    }
}
