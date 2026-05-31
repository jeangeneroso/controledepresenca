package com.example.controledepresenca.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.model.Presenca;

public class PresencaService {

	public List<Presenca> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Presenca incluirPresencaColaborador(Integer colaboradorId, Presenca presenca) {
	    Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
	            .orElseThrow(() -> new RuntimeException(" Colaborador não cadastrado "));

	    presenca.setColaborador(colaborador);
	    presenca.setDia(LocalDate.now()); 
	    return presencaRepository.save(presenca);
	}


	public Presenca incluirPresencaLider(Integer id, Presenca presenca) {
		  Lider lider = liderRepository.findById(liderId)
		            .orElseThrow(() -> new RuntimeException(" Lider não cadastrado "));

		    presenca.setLider(lider);
		    presenca.setDia(LocalDate.now()); 
		    return presencaRepository.save(presenca);
		// TODO Auto-generated method stub
		return null;
	}

}
