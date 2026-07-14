package com.example.controledepresenca.service;

import com.example.controledepresenca.dto.RegistroExtraColaboradorDTO;
import com.example.controledepresenca.dto.RegistroExtraLiderDTO;
import com.example.controledepresenca.model.RegistroExtraColaborador;
import com.example.controledepresenca.model.RegistroExtraLider;
import com.example.controledepresenca.repository.RegistroExtraColaboradorRepository;
import com.example.controledepresenca.repository.RegistroExtraLiderRepository;
import org.springframework.stereotype.Service;
import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.repository.ColaboradorRepository;
import com.example.controledepresenca.repository.LiderRepository;

@Service
public class RegistroExtraService {

    private final RegistroExtraLiderRepository extraLiderRepository;
    private final RegistroExtraColaboradorRepository extraColaboradorRepository;
    private final ColaboradorRepository colaboradorRepository;
    private final LiderRepository liderRepository;

    public RegistroExtraService(RegistroExtraLiderRepository extraLiderRepository, RegistroExtraColaboradorRepository extraColaboradorRepository, ColaboradorRepository colaboradorRepository, LiderRepository liderRepository) {
        this.extraLiderRepository = extraLiderRepository;
        this.extraColaboradorRepository = extraColaboradorRepository;
        this.colaboradorRepository = colaboradorRepository;
        this.liderRepository = liderRepository;
    }

    public RegistroExtraColaborador incluirExtraColaborador(RegistroExtraColaboradorDTO dto) {

        if (dto == null || dto.getColaborador() == null || dto.getColaborador().getId() == null) {
            throw new RuntimeException("Não foi possível salvar: Nenhum ID de Colaborador foi detectado na requisição.");
        }

        Integer idDoColaborador = dto.getColaborador().getId();

        Colaborador colaboradorReal = colaboradorRepository.findById(idDoColaborador)
                .orElseThrow(() -> new RuntimeException("Colaborador com ID " + idDoColaborador + " não existe."));

        RegistroExtraColaborador extra = new RegistroExtraColaborador();
        extra.setColaborador(colaboradorReal);
        extra.setData(dto.getData());
        extra.setQuantidadeHoras(dto.getQuantidadeHoras());

        return extraColaboradorRepository.save(extra);
    }


    public RegistroExtraLider incluirExtraLider(RegistroExtraLiderDTO dto) {

        if (dto == null || dto.getLider() == null || dto.getLider().getId() == null) {
            throw new RuntimeException("Não foi possível salvar: Nenhum ID de Lider foi detectado na requisição.");
        }

        Integer idDoLider = dto.getLider().getId();

        Lider liderReal = liderRepository.findById(idDoLider)
                .orElseThrow(() -> new RuntimeException("Lider com ID " + idDoLider + " não existe."));

        RegistroExtraLider extra = new RegistroExtraLider();
        extra.setLider(liderReal);
        extra.setData(dto.getData());
        extra.setQuantidadeHoras(dto.getQuantidadeHoras());

        return extraLiderRepository.save(extra);
    }
}
