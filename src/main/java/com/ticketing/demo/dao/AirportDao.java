package com.ticketing.demo.dao;

import com.ticketing.demo.model.Airport;
import com.ticketing.demo.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AirportDao {
    @Autowired
    AirportRepository airportRepository;

    public Airport save(Airport airport){
        return airportRepository.save(airport);
    }
    public List<Airport> findAll(){
        return airportRepository.findAll();
    }
    public Airport findOne(Long airportId){
        Optional<Airport> airportOptional = airportRepository.findById(airportId);
        if (airportOptional.isPresent()){
            return airportOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport not found!");
    }
    public void delete(Airport airport){
        airportRepository.delete(airport);
    }

}
