package com.example.controledepresenca.service;

import com.example.controledepresenca.dto.RelatorioDTO;
import com.example.controledepresenca.model.Relatorio;
import com.example.controledepresenca.repository.RelatorioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Service
public class RelatorioService {

    private final RelatorioRepository repository;

    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

   public List<Relatorio> ListarTodos() {
        return repository.findAll();
    }

    public List<Relatorio> buscarPorNomeColaborador(RelatorioDTO dto) {
    	if(dto.getColaborador()== null || dto.getColaborador().getNomeColaborador() == null ) {
    		throw new IllegalArgumentException(" Nome do Colaborador é obrigatório para consulta ");
    	}
    	
        return repository.findByColaborador_NomeColaborador(dto.getColaborador().getNomeColaborador());
    }

    public List<Relatorio> buscarPorNomeLider(RelatorioDTO dto) {
    	if(dto.getLider() == null || dto.getLider().getNomeLider() == null) {

    		throw new IllegalArgumentException(" Nome do Lider é obrigatório ");
    	}

        return repository.findByLider_NomeLider(dto.getLider().getNomeLider());
    }

    public List<Relatorio> buscarPorCpfColaborador(RelatorioDTO dto) {
        if (dto.getColaborador() == null || dto.getColaborador().getCpfColaborador() == null) {

            throw new IllegalArgumentException(" CPF do Colaborador é obrigatório ");
        }

        return repository.findByColaborador_CpfColaborador(dto.getColaborador().getCpfColaborador());

    }
    
    public List<Relatorio> buscarPorCpfLider(RelatorioDTO dto) {
        if (dto.getLider() == null || dto.getLider().getCpfLider() == null) {

            throw new IllegalArgumentException(" CPF do Lider é obrigatório ");

        }
        return repository.findByLider_cpfLider(dto.getLider().getCpfLider());
    }



}
