package com.example.controledepresenca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledegastos.repository.ControleDeGastosRepository;
import com.example.controledepresenca.model.Despesa;

@RestController
public class DespesaController {
	
	@Autowired
	private ControleDeGastosRepository repository;
	
	@GetMapping("/despesas")
	public List<Despesa> getDespesas(){
		return repository.findAll();
		
	}

}
