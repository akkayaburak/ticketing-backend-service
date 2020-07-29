package com.ticketing.demo.controller;

import com.ticketing.demo.Mask;
import com.ticketing.demo.dao.FlightDao;
import com.ticketing.demo.dao.TicketDao;
import com.ticketing.demo.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing")
public class TicketController {
    @Autowired
    TicketDao ticketDao;

    @Autowired
    FlightDao flightDao;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Validated @RequestBody Ticket ticket){
        String number = ticket.getCreditCard().replaceAll("\\D+","");
        if (number.length() != 16){
            return ResponseEntity.badRequest().build();
        }
        ticket.setCreditCard(Mask.maskCardNumber(ticket.getCreditCard()));
        ticketDao.save(ticket);
        //long rotaIdCount = flightDao.countRotaId(ticket.getFlight().getRota().getRotaId());
        //long oldRotaIdCount = rotaIdCount - 1;
        //if(rotaIdCount == oldRotaIdCount + oldRotaIdCount/10){
            //ticket.getFlight().setPrice(ticket.getFlight().getPrice() + ticket.getFlight().getPrice()/10);
        //}
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketDao.findAll();
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "ticketId") Long ticketId){
        Ticket ticket = ticketDao.findOne(ticketId);
        return ResponseEntity.ok().body(ticket);
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable(value = "ticketId") Long ticketId){
        Ticket ticket = ticketDao.findOne(ticketId);
        ticketDao.delete(ticket);
        return ResponseEntity.ok().build();
    }
}
