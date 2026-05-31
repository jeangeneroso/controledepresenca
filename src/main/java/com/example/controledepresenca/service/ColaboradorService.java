package com.example.controledepresenca.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.repository.ColaboradorRepository;

@Service
public class ColaboradorService {

    private final ColaboradorRepository repository;

    public ColaboradorService(ColaboradorRepository repository) {
        this.repository = repository;
    }

    public Colaborador salvar(Colaborador colaborador) {
        if (colaborador.getNomeColaborador() == null || colaborador.getNomeColaborador().isBlank()) {
            throw new IllegalArgumentException("Nome do colaborador é obrigatório");
        }
        return repository.save(colaborador);     
    }
    
    public List<Colaborador> listarTodos() {
        return repository.findAll();
    }

    public Colaborador listarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Colaborador não cadastrado "));
    }
    public Colaborador atualizar(Integer id, Colaborador dadosAtualizados) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Colaborador não cadastrado "));

        colaborador.setNomeColaborador(dadosAtualizados.getNomeColaborador());
        colaborador.setChavePix(dadosAtualizados.getChavePix());
        colaborador.setRodizio(dadosAtualizados.getRodizio());
        // você pode atualizar outros campos conforme necessário

        return repository.save(colaborador);
    }

    public void excluir(Integer id) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Colaborador não cadastrado "));
        repository.delete(colaborador);
    }
}


