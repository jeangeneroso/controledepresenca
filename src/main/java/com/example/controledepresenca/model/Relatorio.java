package com.example.controledepresenca.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "relatorios")
public class Relatorio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_relatorios")
	@SequenceGenerator(
			name = "seq_relatorios",
			sequenceName = "seq_relatorios",
			allocationSize = 1
	)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;

	@ManyToOne
	@JoinColumn(name = "colaborador_lider")
	private Lider lider;

	@ManyToOne
	@JoinColumn(name = "colaborador_operacao")
	private Operacao operacao;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;

	public Relatorio (){

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Lider getLider() {
		return lider;
	}

	public void setLider(Lider lider) {
		this.lider = lider;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
}
