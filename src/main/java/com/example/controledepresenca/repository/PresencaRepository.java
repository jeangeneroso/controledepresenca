package com.example.controledepresenca.repository;

import java.util.List;

import com.example.controledepresenca.model.Presenca;

public interface PresencaRepository {

	List<Presenca> findAll();

	List<Presenca> findByColaboradorId(Integer colaboradorId);

	List<Presenca> findByLiderId(Integer liderId);

	Presenca save(Presenca presenca);

}
