package com.example.controledepresenca.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.controledepresenca.model.Colaborador;

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


/*@Service
public class ColaboradorService {

    private final ColaboradorRepository repository;

    public ColaboradorService(ColaboradorRepository repository) {
        this.repository = repository;
    }

    // Listar todos
    public List<Colaborador> listarTodos() {
        return repository.findAll();
    }

    // Listar apenas um
    public Colaborador listarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
    }

    // Inclusão de um
    public Colaborador salvar(Colaborador colaborador) {
        if (colaborador.getNomeColaborador() == null || colaborador.getNomeColaborador().isBlank()) {
            throw new IllegalArgumentException("Nome do colaborador é obrigatório");
        }
        return repository.save(colaborador);
    }

    // Inclusão de todos (lista)
    public List<Colaborador> salvarTodos(List<Colaborador> colaboradores) {
        return repository.saveAll(colaboradores);
    }

    // Alteração de um
    public Colaborador atualizar(Integer id, Colaborador dadosAtualizados) {
        Colaborador colaborador = listarPorId(id);
        colaborador.setNomeColaborador(dadosAtualizados.getNomeColaborador());
        colaborador.setChavePix(dadosAtualizados.getChavePix());
        colaborador.setRodizio(dadosAtualizados.getRodizio());
        colaborador.setDataPresenca(dadosAtualizados.getDataPresenca());
        return repository.save(colaborador);
    }

    // Alteração de todos
    public List<Colaborador> atualizarTodos(List<Colaborador> colaboradores) {
        return repository.saveAll(colaboradores);
    }

    // Exclusão de um
    public void excluir(Integer id) {
        Colaborador colaborador = listarPorId(id);
        repository.delete(colaborador);
    }
}

*/