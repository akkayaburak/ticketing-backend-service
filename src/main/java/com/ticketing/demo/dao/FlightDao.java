package com.ticketing.demo.dao;

import com.ticketing.demo.exception.NotFoundException;
import com.ticketing.demo.model.Flight;
import com.ticketing.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FlightDao {
    @Autowired
    FlightRepository flightRepository;

    public Flight save(Flight flight){
        return flightRepository.save(flight);
    }

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }

    public Flight findOne(Long flightId){
        Optional<Flight> flightOptional = flightRepository.findById(flightId);
        if (flightOptional.isPresent()){
            return flightOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found!");
    }

    public void delete(Flight flight){
        flightRepository.delete(flight);
    }

    public Flight getQuota(Flight flight){
        return flightRepository.findByFlightId(flight.getFlightId());
    }
}
