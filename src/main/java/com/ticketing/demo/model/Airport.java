package com.ticketing.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "airports")
@EntityListeners(AuditingEntityListener.class)
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airportId;

    @Column(name = "airportName", nullable = false, unique = true)
    private String airportName;
    //@JsonIgnore
    //@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "whereAirport")
    //private List<Rota> airports;
    //private String airportName;

    public long getAirportId() {
        return airportId;
    }

    public void setAirportId(long airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    //public List<Rota> getAirports() {
    //    return airports;
    //}

    //public void setAirports(List<Rota> airports) {
      //  this.airports = airports;
    //}



}
