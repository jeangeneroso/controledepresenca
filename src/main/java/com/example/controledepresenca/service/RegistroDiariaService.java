package com.example.controledepresenca.service;

import com.example.controledepresenca.dto.RegistroDiariaColaboradorDTO;
import com.example.controledepresenca.dto.RegistroDiariaLiderDTO;
import com.example.controledepresenca.repository.RegistroDiariaColaboradorRepository;
import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.model.RegistroDiariaLider;
import com.example.controledepresenca.model.RegistroDiariaColaborador;
import com.example.controledepresenca.repository.ColaboradorRepository;
import com.example.controledepresenca.repository.LiderRepository;
import com.example.controledepresenca.repository.RegistroDiariaLiderRepository;

@Service
public class RegistroDiariaService {

	private final RegistroDiariaLiderRepository diariasLiderRepository;
    private final RegistroDiariaColaboradorRepository diariasColaboradorRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final LiderRepository liderRepository;

    public RegistroDiariaService(RegistroDiariaLiderRepository diariasLiderRepository,
                                 RegistroDiariaColaboradorRepository diariasColaboradorRepository,
                                 ColaboradorRepository colaboradorRepository,
                                 LiderRepository liderRepository) {
        this.diariasLiderRepository = diariasLiderRepository;
        this.diariasColaboradorRepository = diariasColaboradorRepository;
        this.colaboradorRepository = colaboradorRepository;
        this.liderRepository = liderRepository;
    }

    public RegistroDiariaColaborador incluirPresencaColaborador(RegistroDiariaColaboradorDTO dto) {

        if (dto == null || dto.getColaborador() == null || dto.getColaborador().getId() == null) {
            throw new RuntimeException("Não foi possível salvar: Nenhum ID de Colaborador foi detectado na requisição.");
        }

        Integer idDoColaborador = dto.getColaborador().getId();

        Colaborador colaboradorReal = colaboradorRepository.findById(idDoColaborador)
                .orElseThrow(() -> new RuntimeException("Colaborador com ID " + idDoColaborador + " não existe."));

        RegistroDiariaColaborador presenca = new RegistroDiariaColaborador();
        presenca.setColaborador(colaboradorReal);
        presenca.setData(dto.getData());

        return diariasColaboradorRepository.save(presenca);
    }

    public RegistroDiariaLider incluirPresencaLider(RegistroDiariaLiderDTO dto) {

        if (dto == null || dto.getLider() == null || dto.getLider().getId() == null) {
            throw new RuntimeException("Não foi possível salvar: Nenhum ID de Líder foi detectado na requisição.");
        }

        Integer idDoLider = dto.getLider().getId();

        Lider liderReal = liderRepository.findById(idDoLider)
                .orElseThrow(() -> new RuntimeException("Líder com ID " + idDoLider + " não existe."));

        RegistroDiariaLider presenca = new RegistroDiariaLider();
        presenca.setLider(liderReal);
        presenca.setData(dto.getData());;

        return diariasLiderRepository.save(presenca);
    }
}
