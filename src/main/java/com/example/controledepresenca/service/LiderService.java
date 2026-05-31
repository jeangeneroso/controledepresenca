package com.example.controledepresenca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.controledepresenca.model.Lider;

@Service
public class LiderService {

	public List<Lider> listarTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Lider listTodosPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	public Lider salvar(Lider lider) {
		// TODO Auto-generated method stub
		return null;
	}

	public Lider atualizar(Integer id, Lider lider) {
		// TODO Auto-generated method stub
		return null;
	}

	public void excluir(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
}
