package com.example.controledepresenca.service;

import java.util.List;

import com.example.controledepresenca.model.Lider;

public class LiderService {

	public List<Lider> listarTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Lider listTodosPorId() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
