package com.ticketing.demo.repository;

import com.ticketing.demo.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RotaRepository extends JpaRepository<Rota, Long> {
    List<Rota> findByRotaId(Long rotaId);

}
