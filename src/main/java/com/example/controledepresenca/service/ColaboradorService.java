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
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
    }


    public Colaborador incluirPresenca(Integer id, Date dataPresenca) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));

        if (colaborador.getRodizio() == 'S') {
            throw new IllegalStateException("Colaborador está de rodízio e não pode registrar presença");
        }

        colaborador.setDataPresenca(dataPresenca);
        return repository.save(colaborador);
    }

    public Colaborador atualizar(Integer id, Colaborador dadosAtualizados) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));

        colaborador.setNomeColaborador(dadosAtualizados.getNomeColaborador());
        colaborador.setChavePix(dadosAtualizados.getChavePix());
        colaborador.setRodizio(dadosAtualizados.getRodizio());
        // você pode atualizar outros campos conforme necessário

        return repository.save(colaborador);
    }

    public void excluir(Integer id) {
        Colaborador colaborador = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
        repository.delete(colaborador);
    }
}


