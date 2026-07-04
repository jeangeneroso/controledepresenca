package com.example.controledepresenca.dto;

import java.time.LocalDate;

public class RegistroDiariaColaboradorDTO {

	private ColaboradorCadastroDTO colaborador;
	private OperacaoDTO operacao;

	private String nomeColaborador;
	private LocalDate data;

	// Construtor Padrão
	public RegistroDiariaColaboradorDTO() {}

	public ColaboradorCadastroDTO getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorCadastroDTO colaborador) {
		this.colaborador = colaborador;
	}


	public OperacaoDTO getOperacao() {
		return operacao;
	}

	public void setOperacao(OperacaoDTO operacao) {
		this.operacao = operacao;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}