package com.example.controledepresenca.service;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.model.Relatorio;
import com.example.controledepresenca.repository.RelatorioRepository;

import java.util.List;

public class RelatorioService {

    private final RelatorioRepository repository;

    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

   public List<Relatorio> listarColaborador() {
        return repository.findAll();
    }

    public List<Relatorio> listarLider() {
        return repository.findAll();
    }

    public List<Colaborador> getColaborador() {
        return List.of();
    }

    public List<Lider> getLider() {
        return List.of();
    }
}
