package com.example.controledepresenca.model;

import javax.persistence.*;

@Entity
@Table(name = "operacoes")
public class Operacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 20,nullable = false)
	private String nomeOperacao;

	public Operacao() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeOperacao() {
		return nomeOperacao;
	}

	public void setNomeOperacao(String nomeOperacao) {
		this.nomeOperacao = nomeOperacao;
	}
	
}
