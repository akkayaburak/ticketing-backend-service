package com.ticketing.demo.model;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "flights")
@EntityListeners(AuditingEntityListener.class)
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flightId;

    @Column(name = "quota", nullable = false)
    private int quota;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @NotNull
    //@JoinColumn(name = "rotaId", nullable = false)
    private Rota rota;

    @Column(name = "price", nullable = false)
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
}
