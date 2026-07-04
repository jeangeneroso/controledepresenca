package com.example.controledepresenca.dto;

import java.time.LocalDate;

public class RegistroDiariaLiderDTO {

	private LiderCadastroDTO lider;
	private OperacaoDTO operacao;

	private String nomeLider;
	private LocalDate data;

	// Construtor Padrão
	public RegistroDiariaLiderDTO() {}

	public LiderCadastroDTO getLider() {
		return lider;
	}

	public void setLider(LiderCadastroDTO lider) {
		this.lider = lider;
	}

	public OperacaoDTO getOperacao() {
		return operacao;
	}

	public void setOperacao(OperacaoDTO operacao) {
		this.operacao = operacao;
	}

	public String getNomeLider() {
		return nomeLider;
	}

	public void setNomeLider(String nomeLider) {
		this.nomeLider = nomeLider;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}