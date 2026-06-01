package com.example.controledepresenca.exception;

public class ColaboradorNaoEncontradoException extends RuntimeException {

	public ColaboradorNaoEncontradoException(Integer id) {
		super("Colaborador com id " + id + " não cadastrado");
	}

}
