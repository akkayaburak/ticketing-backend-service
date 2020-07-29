package com.ticketing.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rotas")
@EntityListeners(AuditingEntityListener.class)
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rotaId;

    @ManyToOne
    @NotNull
    //@JoinColumn(name = "airlineId")
    private Airline airline;

    @ManyToOne
    @NotNull
    //@JoinColumn(name = "whereAirportId")
    private Airport whereAirport;

    @ManyToOne
    @NotNull
    //@JoinColumn(name = "toAirportId")
    private Airport toAirport;

    //@OneToMany(targetEntity = Flight.class, fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "rota")
    //@JsonIgnore
    //private List<Flight> flights;


    public long getRotaId() {
        return rotaId;
    }

    public void setRotaId(long rotaId) {
        this.rotaId = rotaId;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Airport getWhereAirport() {
        return whereAirport;
    }

    public void setWhereAirport(Airport whereAirport) {
        this.whereAirport = whereAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

}
