package com.ticketing.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "airlines")
@EntityListeners(AuditingEntityListener.class)
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airlineId;

    @Column(name = "airlineName", nullable = false, unique = true)
    private String airlineName;
    //@JsonIgnore
    //@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "airline")
    //private List<Rota> rotas;
    //private String airlineName;

    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String  airlineName) {
        this.airlineName = airlineName;
    }

    //public List<Rota> getRotas() {
      //  return rotas;
    //}

    //public void setRotas(List<Rota> rotas) {
      //  this.rotas = rotas;
    //}
}
