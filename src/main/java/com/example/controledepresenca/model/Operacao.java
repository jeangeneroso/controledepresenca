package com.example.controledepresenca.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "operacoes")
public class Operacao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_operacoes")
	@SequenceGenerator(
			name = "seq_operacoes",
			sequenceName = "seq_operacoes",
			allocationSize = 1
	)
	private Integer id;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 30 )
	@Column(length = 30,nullable = false)
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
