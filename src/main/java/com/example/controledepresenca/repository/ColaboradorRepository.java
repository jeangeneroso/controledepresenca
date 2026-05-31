package com.example.controledepresenca.repository;

import java.util.List;

import com.example.controledepresenca.model.Colaborador;

public interface ColaboradorRepository {

	List<Colaborador> findAll();

	Colaborador save(Colaborador colaborador);

	Object findById(Integer id);

	void delete(Colaborador colaborador);


}
