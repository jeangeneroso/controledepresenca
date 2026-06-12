package com.example.controledepresenca.repository;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelatorioRepository extends JpaRepository<Relatorio, Integer> {

    List<Colaborador> getColaborador ();

}
