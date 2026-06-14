package com.example.controledepresenca.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "presenca")
public class RegistroDiaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDate dia;

	@ManyToOne
	@JoinColumn(name = "operacao_id")
	private Operacao operacao;

	@ManyToOne
	@JoinColumn(name = "lider_id")
	private Lider lider;

	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;
	
	private String funcao;

	@Enumerated(EnumType.STRING)
	private StatusDiarias status; // status da presença

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Lider getLider() {
		return lider;
	}

	public void setLider(Lider lider) {
		this.lider = lider;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public StatusDiarias getStatus() {
		return status;
	}

	public void setStatus(StatusDiarias status) {
		this.status = status;
	}

}
