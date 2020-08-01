package com.ticketing.demo.dao;

import com.ticketing.demo.exception.NotFoundException;
import com.ticketing.demo.model.Rota;
import com.ticketing.demo.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RotaDao {
    @Autowired
    RotaRepository rotaRepository;

    public Rota save(Rota rota){
        return rotaRepository.save(rota);

    }
    public List<Rota> findAll(){
        return rotaRepository.findAll();
    }
    public Rota findOne(Long rotaId){
        Optional<Rota> rotaOptional = rotaRepository.findById(rotaId);
        if (rotaOptional.isPresent()){
            return rotaOptional.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rota not found!");
    }
    public void delete(Rota rota){
        rotaRepository.delete(rota);
    }
}
