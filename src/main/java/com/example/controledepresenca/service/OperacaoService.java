package com.example.controledepresenca.service;

import java.util.List;

import com.example.controledepresenca.repository.OperacaoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Operacao;

import org.springframework.cache.annotation.Cacheable;


@Service
public class OperacaoService {

	private final OperacaoRepository repository;

    public OperacaoService(OperacaoRepository repository) {
        this.repository = repository;
    }

	@Cacheable("operacoes")
    public List<Operacao> listarTodos() {
		return repository.findAll();
	}

	@Cacheable(value = "operacoes", key = "#id")
	public Operacao listarPorId(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException(" Operação não cadastrada "));
	}

	@CacheEvict(value = "operacoes", allEntries = true)
	public Operacao salvar(Operacao operacao) {
		// TODO Auto-generated method stub

		if (operacao.getNomeOperacao() == null || operacao.getNomeOperacao() .trim().isEmpty()) {
			throw new IllegalArgumentException(" Nome da Operação é Obrigatoria ");
		}
		return repository.save(operacao);
	}

	@CacheEvict(value = "...", allEntries = true)
	public Operacao atualizar(Integer id, Operacao operacao) {
		operacao.setId(id);
		return repository.save(operacao);
	}

	@CacheEvict(value = "operacoes", allEntries = true)
	public void excluir(Integer id) {
		Operacao operacao = repository.findById(id)
				.orElseThrow(() -> new RuntimeException(" Operacao não cadastrada "));
		repository.delete(operacao);

	}
}
