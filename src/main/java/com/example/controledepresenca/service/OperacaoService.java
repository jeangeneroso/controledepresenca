package com.example.controledepresenca.service;

import java.util.List;
import com.example.controledepresenca.repository.OperacaoRepository;
import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Operacao;

@Service
public class OperacaoService {

	private final OperacaoRepository Repository;

    public OperacaoService(OperacaoRepository repository) {
        Repository = repository;
    }

    public List<Operacao> listarTodos() {
		return Repository.findAll();
	}

	public Operacao salvar(Operacao operacao) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluir(Integer id) {
		Operacao operacao = Repository.findById(id)
				.orElseThrow(() -> new RuntimeException(" Operacao não cadastrada "));
		Repository.delete(operacao);

	}

}
