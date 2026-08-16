package com.example.controledepresenca.service;

import java.util.List;

import com.example.controledepresenca.dto.LiderCadastroDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.repository.LiderRepository;

import org.springframework.cache.annotation.Cacheable;

@Service
public class LiderService {

	private final LiderRepository repository;

	public LiderService(LiderRepository repository) {
		this.repository = repository;
	}

	@Cacheable("lideres")
	public List<Lider> listarTodos() {
		return repository.findAll();
	}

	@Cacheable(value = "lideres", key = "#id")
	public Lider listarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@CacheEvict(value = "lideres", allEntries = true)
	public Lider salvar(LiderCadastroDTO dto) {

		if (dto.getNomeLider() == null || dto.getNomeLider().trim().isEmpty()) {
			throw new IllegalArgumentException("Nome do lider é obrigatório");

		}

		if (dto.getId() == null && repository.existsByCpfLider(dto.getCpfLider())) {
			throw new RuntimeException("Já existe um cadastrado com este CPF: " + dto.getCpfLider());
		}

		// Validation: CPF duplicado ao atualizar um cadastro existente
		if (dto.getId() != null && repository.existsByCpfLiderAndIdNot(dto.getCpfLider(), dto.getId())) {
			throw new RuntimeException("Este CPF já está associado a outro auxiliar.");
		}
			Lider lider = new Lider();
			lider.setNomeLider(dto.getNomeLider());
			lider.setRgLider(dto.getRgLider());
			lider.setCpfLider(dto.getCpfLider());
			lider.setChavePix(dto.getChavePix());

		return repository.save(lider);
	}

	@CacheEvict(value = "...", allEntries = true)
	public Lider atualizar(Integer id, LiderCadastroDTO dadosAtualizados) {
		// TODO Auto-generated method stub

		Lider lider = repository.findById(id)
				.orElseThrow(() -> new RuntimeException(" Lider não cadastrado "));
		lider.setNomeLider(dadosAtualizados.getNomeLider());
		lider.setRgLider(dadosAtualizados.getRgLider());
		lider.setCpfLider(dadosAtualizados.getCpfLider());
		lider.setChavePix(dadosAtualizados.getChavePix());
		return repository.save(lider);
	}

	@CacheEvict(value = "lideres", allEntries = true)
	public void excluir(Integer id) {
		Lider lider = repository.findById(id).orElseThrow(() -> new RuntimeException(" Lider não cadastrado "));
		repository.delete(lider);
	}

}
