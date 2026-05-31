package com.example.controledepresenca.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "colaboradores") // nome da tabela no banco
public class Colaborador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Integer id;

    @Column(nullable = false)
    private String nomeColaborador;

    private String chavePix;

    private Double valorDiaria = 130.00;
    private Double somaTotalDiaria;

    private Double valorHoraExtra = 12.00;
    private Double somaTotalHoraExtra;
    
 // Relacionamento com Operacao
    @ManyToOne
    @JoinColumn(name = "operacao_id")
    private Operacao operacao;
    
 // Relacionamento com Presenca
    @OneToMany(mappedBy = "colaborador")
    private List<Presenca> presencas;

    public Colaborador() {
    	
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

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public List<Presenca> getPresencas() {
		return presencas;
	}

	public void setPresencas(List<Presenca> presencas) {
		this.presencas = presencas;
	}
	
}
