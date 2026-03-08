package com.example.controledepresenca.model;

import java.util.Date;

public class Colaborador {
	
	private Integer id;
	private String nomeColaborador;
	private String chavePix;
	private Date dataPresenca;
	private Double valorDiaria = 130.00;
	private Double somaTotalDiaria;
	private Double valorHoraExtra = 12.00;
	private Double somaTotalHoraExtra;
	private char rodizio;
	
	public Colaborador () {
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	public Date getDataPresenca() {
		return dataPresenca;
	}

	public void setDataPresenca(Date dataPresenca) {
		this.dataPresenca = dataPresenca;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Double getSomaTotalDiaria() {
		return somaTotalDiaria;
	}

	public void setSomaTotalDiaria(Double somaTotalDiaria) {
		this.somaTotalDiaria = somaTotalDiaria;
	}

	public Double getValorHoraExtra() {
		return valorHoraExtra;
	}

	public void setValorHoraExtra(Double valorHoraExtra) {
		this.valorHoraExtra = valorHoraExtra;
	}

	public Double getSomaTotalHoraExtra() {
		return somaTotalHoraExtra;
	}

	public void setSomaTotalHoraExtra(Double somaTotalHoraExtra) {
		this.somaTotalHoraExtra = somaTotalHoraExtra;
	}

	public char getRodizio() {
		return rodizio;
	}

	public void setRodizio(char rodizio) {
		this.rodizio = rodizio;
	}

}
