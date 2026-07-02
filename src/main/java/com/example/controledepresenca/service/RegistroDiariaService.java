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

        if (presenca.getColaborador() == null) {
            presenca.setColaborador(new Colaborador());
        }

        Integer idDoColaborador = presenca.getColaborador().getId();

        if (idDoColaborador == null) {
            throw new RuntimeException("Não foi possível salvar: Nenhum ID de Colaborador foi detectado na requisição.");
        }

        Colaborador colaboradorReal = colaboradorRepository.findById(idDoColaborador)
                .orElseThrow(() -> new RuntimeException("Colaborador com ID " + idDoColaborador + " não existe."));

        presenca.setColaborador(colaboradorReal);
        presenca.setData(LocalDate.now());

        // 4. Salva o registro (o ID da diária incrementa sozinho aqui)
        return presencaRepository.save(presenca);
    }

    public RegistroDiaria incluirPresencaLider(RegistroDiaria presenca) {
        // 1. Evita o NullPointerException se o objeto 'lider' vier nulo do Angular
        if (presenca.getLider() == null) {
            presenca.setLider(new Lider());
        }

        Integer idDoLider = presenca.getLider().getId();

        // 2. Se o ID não foi capturado, avisa o erro sem travar o servidor
        if (idDoLider == null) {
            throw new RuntimeException("Não foi possível salvar: Nenhum ID de Líder foi detectado na requisição.");
        }

        // 3. Busca o líder real para o relacionamento
        Lider liderReal = liderRepository.findById(idDoLider)
                .orElseThrow(() -> new RuntimeException("Líder com ID " + idDoLider + " não existe."));

        presenca.setLider(liderReal);
        presenca.setData(LocalDate.now());

        // 4. Salva o registro (o ID da diária incrementa sozinho aqui)
        return presencaRepository.save(presenca);
    }
	
}
