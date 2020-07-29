package com.ticketing.demo.repository;

import com.ticketing.demo.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Long flight(Long rotaId);
}
