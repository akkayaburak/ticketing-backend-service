package com.ticketing.demo.dao;

import com.ticketing.demo.model.Ticket;
import com.ticketing.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TicketDao {
    @Autowired
    TicketRepository ticketRepository;

    public Ticket save(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public List<Ticket> findAll(){
        return ticketRepository.findAll();
    }

    public Ticket findOne(Long ticketId){
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (ticketOptional.isPresent()){
            return ticketOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found!");
    }

    public void delete(Ticket ticket){
        ticketRepository.delete(ticket);
    }

    public List<Ticket> findByFlightId(Long flightId){
        return ticketRepository.findByFlightFlightId(flightId);
    }

}
