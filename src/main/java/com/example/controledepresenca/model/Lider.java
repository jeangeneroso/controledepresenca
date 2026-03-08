package com.example.controledepresenca.model;

import java.sql.Date;

public class Lider {
	
	private Integer id;
	private String nomeLider;
	private String chavePix;
	private Date dataPresenca;
	private Double valorDiaria = 160.00;
	private Double somaTotalDiaria;
	private Double valorHoraExtra = 15.00;
	private Double somaTotalHoraExtra;
	
	public Lider () {
			
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeLider() {
		return nomeLider;
	}

	public void setNomeLider(String nomeLider) {
		this.nomeLider = nomeLider;
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
	
}
