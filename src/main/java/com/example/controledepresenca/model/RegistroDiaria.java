package com.example.controledepresenca.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "diaria")
public class RegistroDiaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "operacao_id")
	private Operacao operacao;

	@ManyToOne
	@JoinColumn(name = "lider_id")
	private Lider lider;

	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

	@Enumerated(EnumType.STRING)
	private StatusDiarias status; // status da presença

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate dia) {
		this.data = data;
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
