package com.example.controledepresenca.service;

import java.time.LocalDate;
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

    public RegistroDiaria incluirPresencaColaborador(RegistroDiaria presenca) {
        Integer idDoColaborador = presenca.getColaborador().getId();
        Colaborador colaborador = colaboradorRepository.findById(idDoColaborador)
                .orElseThrow(() -> new RuntimeException("Diaria do colaborador não cadastrado"));

        presenca.setColaborador(colaborador);
        presenca.setData(LocalDate.now());
        return presencaRepository.save(presenca);
    }

    public RegistroDiaria incluirPresencaLider(RegistroDiaria presenca) {
        Integer idDoLider = presenca.getLider().getId();
        Lider lider = liderRepository.findById(idDoLider)
                .orElseThrow(() -> new RuntimeException("Diaria do lide não cadastrado"));

        presenca.setLider(lider);
        presenca.setData(LocalDate.now());
        return presencaRepository.save(presenca);
    }
	
}
