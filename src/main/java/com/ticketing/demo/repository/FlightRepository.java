package com.ticketing.demo.repository;

import com.sun.istack.NotNull;
import com.ticketing.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByFlightId(long flightId);
}
