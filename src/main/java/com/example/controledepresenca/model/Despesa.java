package com.example.controledepresenca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "despesas") // Nome da tabela no banco de dados
public class Despesa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	private Double valor;
	private String cartaoNubank = " Nubank ";
	private String cartaoInter = " Banco Inter ";
	private String cartaoBtg = " Banco BTG ";
	private String cartaoXp = " Banco XP ";
	private Boolean situacao;

	public Despesa() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCartaoNubank() {
		return cartaoNubank;
	}

	public void setCartaoNubank(String cartaoNubank) {
		this.cartaoNubank = cartaoNubank;
	}

	public String getCartaoInter() {
		return cartaoInter;
	}

	public void setCartaoInter(String cartaoInter) {
		this.cartaoInter = cartaoInter;
	}

	public String getCartaoBtg() {
		return cartaoBtg;
	}

	public void setCartaoBtg(String cartaoBtg) {
		this.cartaoBtg = cartaoBtg;
	}

	public String getCartaoXp() {
		return cartaoXp;
	}

	public void setCartaoXp(String cartaoXp) {
		this.cartaoXp = cartaoXp;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
		Boolean pago = null;
		if (situacao = pago) {
			
		}
	}
	
}
