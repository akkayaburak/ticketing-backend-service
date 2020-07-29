package com.ticketing.demo.dao;

import com.ticketing.demo.model.Airline;
import com.ticketing.demo.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineDao {
    @Autowired
    AirlineRepository airlineRepository;

    public Airline save(Airline airline){
        return airlineRepository.save(airline);
    }
    public List<Airline> findAll(){
        return airlineRepository.findAll();
    }
    public Airline findOne(Long airlineId){
        Optional<Airline> airlineOptional = airlineRepository.findById(airlineId);
        Airline airline = airlineOptional.get();
        return airline;
    }
    public void delete(Airline airline){
        airlineRepository.delete(airline);
    }
}
