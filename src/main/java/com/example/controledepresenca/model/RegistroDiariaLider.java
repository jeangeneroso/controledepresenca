package com.example.controledepresenca.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "diariaLider")
public class RegistroDiariaLider {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_diariaLider")
	@SequenceGenerator(
			name = "seq_diariaLider",
			sequenceName = "seq_diariaLider",
			allocationSize = 1
	)
	private Integer id;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	@ManyToOne
	@JoinColumn(name = "operacao_id")
	private Operacao operacao;

	@ManyToOne
	@JoinColumn(name = "lider_id")
	private Lider lider;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	private StatusAprovacao status = StatusAprovacao.PENDENTE;

	public RegistroDiariaLider() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
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

	@JsonProperty("lider")
	public void setLider(Lider lider) {
		this.lider = lider;
	}

	public StatusAprovacao getStatus() {
		return status;
	}

	public void setStatus(StatusAprovacao status) {
		this.status = status;
	}

}
