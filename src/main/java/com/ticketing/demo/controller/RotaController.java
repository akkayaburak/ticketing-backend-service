package com.ticketing.demo.controller;

import com.ticketing.demo.dao.RotaDao;
import com.ticketing.demo.model.Rota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticketing")
public class RotaController {
    @Autowired
    RotaDao rotaDao;

    @PostMapping("/rotas")
    public ResponseEntity<Rota> createRota(@Validated @RequestBody Rota rota){
        rotaDao.save(rota);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rotas")
    public List<Rota> getAllRotas(){
        return rotaDao.findAll();
    }

    @GetMapping("/rotas/{rotaId}")
    public ResponseEntity<Rota> getRotaById(@PathVariable (value = "rotaId") Long rotaId){
        Rota rota = rotaDao.findOne(rotaId);
        if (rota == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(rota);
    }

    @PutMapping("/rotas/{rotaId}")
    public ResponseEntity<Rota> updateRota(@PathVariable(value = "rotaId") Long rotaId, @Validated @RequestBody Rota rotaDetails){
        Rota rota = rotaDao.findOne(rotaId);
        if (rota == null) {
            return ResponseEntity.notFound().build();
        }
        rota.setAirline(rotaDetails.getAirline());
        rota.setToAirport(rotaDetails.getToAirport());
        rota.setWhereAirport(rotaDetails.getWhereAirport());
        Rota updateRota = rotaDao.save(rota);
        return ResponseEntity.ok().body(updateRota);
    }

    @DeleteMapping("/rotas/{rotaId}")
    public ResponseEntity<Rota> deleteRota(@PathVariable(value = "rotaId") Long rotaId){
        Rota rota = rotaDao.findOne(rotaId);
        if (rota == null){
            return ResponseEntity.notFound().build();
        }
        rotaDao.delete(rota);
        return ResponseEntity.ok().build();
    }

}
