package com.ticketing.demo.repository;

import com.ticketing.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Long flight(Long rotaId);
    List<Ticket> findByFlightFlightId(Long flightId);
}
