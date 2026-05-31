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
public class Presenca {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
	@Enumerated(EnumType.STRING)
	private StatusPresenca status; // status da presença

}
