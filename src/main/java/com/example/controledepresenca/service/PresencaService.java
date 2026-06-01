package com.example.controledepresenca.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.model.Presenca;
import com.example.controledepresenca.repository.ColaboradorRepository;
import com.example.controledepresenca.repository.LiderRepository;
import com.example.controledepresenca.repository.PresencaRepository;

@Service
public class PresencaService {
	
	private final PresencaRepository presencaRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final LiderRepository liderRepository;

    public PresencaService(PresencaRepository presencaRepository,
                           ColaboradorRepository colaboradorRepository,
                           LiderRepository liderRepository) {
        this.presencaRepository = presencaRepository;
        this.colaboradorRepository = colaboradorRepository;
        this.liderRepository = liderRepository;
    }

    public List<Presenca> listarTodos() {
        return presencaRepository.findAll();
    }

    public List<Presenca> listarPorColaborador(Integer colaboradorId) {
        return presencaRepository.findByColaboradorId(colaboradorId);
    }

    public List<Presenca> listarPorLider(Integer liderId) {
        return presencaRepository.findByLiderId(liderId);
    }

    public Presenca incluirPresencaColaborador(Integer colaboradorId, Presenca presenca) {
        Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
                .orElseThrow(() -> new RuntimeException("Colaborador não cadastrado"));

        presenca.setColaborador(colaborador);
        presenca.setDia(LocalDate.now()); 
        return presencaRepository.save(presenca);
    }

    public Presenca incluirPresencaLider(Integer liderId, Presenca presenca) {
        Lider lider = liderRepository.findById(liderId)
                .orElseThrow(() -> new RuntimeException("Líder não cadastrado"));

        presenca.setLider(lider);
        presenca.setDia(LocalDate.now()); 
        return presencaRepository.save(presenca);
    }
	
/*	private final PresencaRepository presencaRepository;

    public PresencaService(PresencaRepository presencaRepository) {
        this.presencaRepository = presencaRepository;
    }

	public List<Presenca> listarTodos() {
        return presencaRepository.findAll();
	}

    public List<Presenca> listarPorColaborador(Integer colaboradorId) {
        return presencaRepository.findByColaboradorId(colaboradorId);
    }

    public List<Presenca> listarPorLider(Integer liderId) {
        return presencaRepository.findByLiderId(liderId);
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
	}*/
	
    
	
}
