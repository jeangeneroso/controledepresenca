package com.example.controledepresenca.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "extraColaborador")
public class RegistroExtraColaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_extraColaborador")
    @SequenceGenerator(
            name = "seq_extraColaborador",
            sequenceName = "seq_extraColaborador",
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

    @JoinColumn(name = "hora")
    private Integer quantidadeHoras;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusAprovacao status = StatusAprovacao.PENDENTE;

    public RegistroExtraColaborador (){

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
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Integer getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Integer quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

}
