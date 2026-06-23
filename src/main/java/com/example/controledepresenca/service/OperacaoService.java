package com.example.controledepresenca.service;

import java.util.List;
import com.example.controledepresenca.repository.OperacaoRepository;
import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Operacao;

@Service
public class OperacaoService {

	private final OperacaoRepository repository;

    public OperacaoService(OperacaoRepository repository) {
        this.repository = repository;
    }

    public List<Operacao> listarTodos() {
		return repository.findAll();
	}

	public Operacao salvar(Operacao operacao) {
		// TODO Auto-generated method stub

		if (operacao.getNomeOperacao() == null || operacao.getNomeOperacao() .trim().isEmpty()) {
			throw new IllegalArgumentException(" Nome da Operação é Obrigatoria ");
		}
		return repository.save(operacao);
	}

	public void excluir(Integer id) {
		Operacao operacao = repository.findById(id)
				.orElseThrow(() -> new RuntimeException(" Operacao não cadastrada "));
		repository.delete(operacao);

	}

}
