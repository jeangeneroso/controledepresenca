package com.example.controledepresenca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.repository.LiderRepository;

@Service
public class LiderService {

	private final LiderRepository repository;

	public LiderService(LiderRepository repository) {
		this.repository = repository;
	}

	public List<Lider> listarTodos() {
		return repository.findAll();
	}

	public Lider listarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public Lider salvar(Lider lider) {
		// TODO Auto-generated method stub

		if (lider.getNomeLider() == null || lider.getNomeLider().trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do colaborador é obrigatório");
		}
		return repository.save(lider);
	}

	public Lider atualizar(Integer id, Lider dadosAtualizados) {
		// TODO Auto-generated method stub

		Lider lider = repository.findById(id)
				.orElseThrow(() -> new RuntimeException(" Lider não cadastrado "));
		lider.setNomeLider(dadosAtualizados.getNomeLider());
		lider.setChavePix(dadosAtualizados.getChavePix());
		return repository.save(lider);
	}

	public void excluir(Integer id) {
		Lider lider = repository.findById(id).orElseThrow(() -> new RuntimeException(" Lider não cadastrado "));
		repository.delete(lider);
	}

}
