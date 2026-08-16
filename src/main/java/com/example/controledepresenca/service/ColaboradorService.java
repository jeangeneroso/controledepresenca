package com.example.controledepresenca.service;

import java.util.List;

import com.example.controledepresenca.dto.ColaboradorCadastroDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.example.controledepresenca.exception.ColaboradorNaoEncontradoException;
import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.repository.ColaboradorRepository;

import org.springframework.cache.annotation.Cacheable;

@Service
public class ColaboradorService {

    private final ColaboradorRepository repository;

    public ColaboradorService(ColaboradorRepository repository) {
        this.repository = repository;
    }

    @Cacheable("colaboradores")
    public List<Colaborador> listarTodos() {
        return repository.findAll();
    }

    @Cacheable(value = "colaboradores", key = "#id")
    public Colaborador listarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Colaborador não cadastrado "));
    }

    @CacheEvict(value = "colaboradores", allEntries = true)
    public Colaborador salvar(ColaboradorCadastroDTO dto) {
        if (dto.getNomeColaborador() == null || dto.getNomeColaborador().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do colaborador é obrigatório");
        }

        if (dto.getId() == null && repository.existsByCpfColaborador(dto.getCpfColaborador())) {
            throw new RuntimeException("Já existe um cadastrado com este CPF: " + dto.getCpfColaborador());
        }

        // Validation: CPF duplicado ao atualizar um cadastro existente
        if (dto.getId() != null && repository.existsByCpfColaboradorAndIdNot(dto.getCpfColaborador(), dto.getId())) {
            throw new RuntimeException("Este CPF já está associado a outro auxiliar.");
        }

        // CORREÇÃO: Transforma o DTO em Entidade antes de salvar
        Colaborador colaborador = new Colaborador();
        colaborador.setNomeColaborador(dto.getNomeColaborador());
        colaborador.setRgColaborador(dto.getRgColaborador());
        colaborador.setCpfColaborador(dto.getCpfColaborador());
        colaborador.setChavePix(dto.getChavePix());

        return repository.save(colaborador);
    }

    @CacheEvict(value = "...", allEntries = true)
    public Colaborador atualizar(Integer id, ColaboradorCadastroDTO dadosAtualizados) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não cadastrado"));

        colaborador.setNomeColaborador(dadosAtualizados.getNomeColaborador());
        colaborador.setRgColaborador(dadosAtualizados.getRgColaborador());
        colaborador.setCpfColaborador(dadosAtualizados.getCpfColaborador());
        colaborador.setChavePix(dadosAtualizados.getChavePix());
        return repository.save(colaborador);
    }

    @CacheEvict(value = "colaboradores", allEntries = true)
    public void excluir(Integer id) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new ColaboradorNaoEncontradoException(id));
        repository.delete(colaborador);
    }

}


