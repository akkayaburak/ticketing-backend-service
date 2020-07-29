package com.ticketing.demo.dao;

import com.ticketing.demo.model.Ticket;
import com.ticketing.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

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
        Ticket ticket = ticketOptional.get();
        return ticket;
    }

    public void delete(Ticket ticket){
        ticketRepository.delete(ticket);
    }

    @Query("SELECT COUNT(tickets) FROM tickets WHERE tickets.rotaId=?1")
    public Long countRotaIds(Long rotaId) {
        return ticketRepository.flight(rotaId);
    }

}
