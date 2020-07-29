package com.ticketing.demo.dao;

import com.ticketing.demo.model.Flight;
import com.ticketing.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Flight flight = flightOptional.get();
        return flight;
    }

    public void delete(Flight flight){
        flightRepository.delete(flight);
    }
}
