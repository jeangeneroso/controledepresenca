package com.example.controledepresenca.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "colaboradores") // nome da tabela no banco
public class Colaborador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Integer id;

	@Column(length = 150, nullable = false)
    private String nomeColaborador;

	@Column(length = 15,nullable = false)
	private String rgColaborador;

	@Column(length = 15,nullable = false)
	private String cpfColaborador;

	@Column(length = 50,nullable = false)
    private String chavePix;

 // Relacionamento com Operacao
    @ManyToOne
    @JoinColumn(name = "operacao_id")
    private Operacao operacao;
    
 // Relacionamento com Presenca
 	@OneToMany(mappedBy = "colaborador")
 	@JsonIgnoreProperties("colaborador")
    private List<RegistroDiariaColaborador> presencas;

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

	public String getCpfColaborador() {
		return cpfColaborador;
	}

	public void setCpfColaborador(String cpfColaborador) {
		this.cpfColaborador = cpfColaborador;
	}

	public String getRgColaborador() {
		return rgColaborador;
	}

	public void setRgColaborador(String rgColaborador) {
		this.rgColaborador = rgColaborador;
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

	@OneToMany(mappedBy = "lider")
	@JsonIgnoreProperties("lider")
	public List<RegistroDiariaColaborador> getPresencas() {
		return presencas;
	}

	public void setPresencas(List<RegistroDiariaColaborador> presencas) {
		this.presencas = presencas;
	}
}
