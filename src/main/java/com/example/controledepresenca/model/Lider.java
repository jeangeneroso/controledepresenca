package com.example.controledepresenca.model;

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

@Entity
@Table(name = "lideres") // nome da tabela no banco
public class Lider {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
	private Integer id;
    
    @Column(length = 150, nullable = false)
	private String nomeLider;

	@Column(length = 15,nullable = false)
	private String rgLider;

	@Column(length = 15,nullable = false)
	private String cpfLider;
    
    @Column(length = 50,nullable = false)
	private String chavePix;
	
	// Relacionamento com Operacao
    @ManyToOne
    @JoinColumn(name = "operacao_id")
    private Operacao operacao;
	
	 // Relacionamento com Presenca
    @OneToMany(mappedBy = "lider")
    private List<RegistroDiaria> presencas;
	
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

	public String getRgLider() {
		return rgLider;
	}

	public void setRgLider(String rgLider) {
		this.rgLider = rgLider;
	}

	public String getCpfLider() {
		return cpfLider;
	}

	public void setCpfLider(String cpfLider) {
		this.cpfLider = cpfLider;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public List<RegistroDiaria> getPresencas() {
		return presencas;
	}

	public void setPresencas(List<RegistroDiaria> presencas) {
		this.presencas = presencas;
	}	
	
}
