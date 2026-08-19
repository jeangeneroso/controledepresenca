package com.example.controledepresenca.repository;

import com.example.controledepresenca.model.DiariaRegistrada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiariaRegistradaRepository  extends JpaRepository<DiariaRegistrada, Integer> {

    List<DiariaRegistrada> findAll();

    void delete(DiariaRegistrada diariaRegistrada);

}
