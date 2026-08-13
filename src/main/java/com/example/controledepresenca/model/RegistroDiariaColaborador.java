package com.example.controledepresenca.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diariaColaborador")
public class RegistroDiariaColaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_diariaColaborador")
    @SequenceGenerator(
            name = "seq_diariaColaborador",
            sequenceName = "seq_diariaColaborador",
            allocationSize = 1
    )
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "operacao_id")
    private Operacao operacao;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusAprovacao status = StatusAprovacao.PENDENTE;

    public RegistroDiariaColaborador (){

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

    public Colaborador getColaborador() {
        return this.colaborador;
    }

    @JsonProperty("colaborador")
    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
