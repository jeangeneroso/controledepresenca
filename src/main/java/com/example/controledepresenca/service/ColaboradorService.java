package com.example.controledepresenca.service;

import java.util.List;

import com.example.controledepresenca.dto.ColaboradorCadastroDTO;
import org.springframework.stereotype.Service;

import com.example.controledepresenca.exception.ColaboradorNaoEncontradoException;
import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.repository.ColaboradorRepository;

@Service
public class ColaboradorService {

    private final ColaboradorRepository repository;

    public ColaboradorService(ColaboradorRepository repository) {
        this.repository = repository;
    }
    
    public List<Colaborador> listarTodos() {
        return repository.findAll();
    }
        
   
    public Colaborador listarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Colaborador não cadastrado "));
    }

    public Colaborador salvar(ColaboradorCadastroDTO dto) {
        if (dto.getNomeColaborador() == null || dto.getNomeColaborador().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do colaborador é obrigatório");
        }

        // CORREÇÃO: Transforma o DTO em Entidade antes de salvar
        Colaborador colaborador = new Colaborador();
        colaborador.setNomeColaborador(dto.getNomeColaborador());
        colaborador.setRgColaborador(dto.getRgColaborador());
        colaborador.setCpfColaborador(dto.getCpfColaborador());
        colaborador.setChavePix(dto.getChavePix());

        return repository.save(colaborador);
    }

    public Colaborador atualizar(Integer id, ColaboradorCadastroDTO dadosAtualizados) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não cadastrado"));

        colaborador.setNomeColaborador(dadosAtualizados.getNomeColaborador());
        colaborador.setChavePix(dadosAtualizados.getChavePix());

        // Se quiser que o PUT também atualize RG e CPF, descomente as linhas abaixo:
        // colaborador.setRgColaborador(dadosAtualizados.getRgColaborador());
        // colaborador.setCpfColaborador(dadosAtualizados.getCpfColaborador());

        // CORREÇÃO: Salva a entidade 'colaborador' que foi atualizada
        return repository.save(colaborador);
    }

    public void excluir(Integer id) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new ColaboradorNaoEncontradoException(id));
        repository.delete(colaborador);
    }

}


