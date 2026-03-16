package com.example.controledepresenca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledepresenca.model.Despesa;
import com.example.controledepresenca.repository.ControleDePresencaRepository;


@RestController
public class DespesaService {
	
	@Autowired
	private ControleDePresencaRepository repository;
	
	@GetMapping("/despesas")
	public List<Despesa> getDespesas(){
		return repository.findAll();
		
	}

}
