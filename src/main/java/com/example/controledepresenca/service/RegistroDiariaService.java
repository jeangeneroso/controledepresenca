package com.example.controledepresenca.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.model.RegistroDiaria;
import com.example.controledepresenca.repository.ColaboradorRepository;
import com.example.controledepresenca.repository.LiderRepository;
import com.example.controledepresenca.repository.RegistroDiariaRepository;

@Service
public class RegistroDiariaService {
	
	private final RegistroDiariaRepository presencaRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final LiderRepository liderRepository;

    public RegistroDiariaService(RegistroDiariaRepository presencaRepository,
                           ColaboradorRepository colaboradorRepository,
                           LiderRepository liderRepository) {
        this.presencaRepository = presencaRepository;
        this.colaboradorRepository = colaboradorRepository;
        this.liderRepository = liderRepository;
    }

    public RegistroDiaria incluirPresencaColaborador(Integer colaboradorId, RegistroDiaria presenca) {
        Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
                .orElseThrow(() -> new RuntimeException("Colaborador não cadastrado"));

        presenca.setColaborador(colaborador);
        presenca.setDia(LocalDate.now()); 
        return presencaRepository.save(presenca);
    }

    public RegistroDiaria incluirPresencaLider(Integer liderId, RegistroDiaria presenca) {
        Lider lider = liderRepository.findById(liderId)
                .orElseThrow(() -> new RuntimeException("Líder não cadastrado"));

        presenca.setLider(lider);
        presenca.setDia(LocalDate.now()); 
        return presencaRepository.save(presenca);
    }
	
}
