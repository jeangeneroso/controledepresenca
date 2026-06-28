package com.example.controledepresenca.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diarias_registradas")
public class DiariaRegistrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
    private Integer id;

    private LocalDate data;

    @Column(length = 10,nullable = false)
    private String funcao;

    @ManyToOne
    @JoinColumn(name = "operacao_id")
    private Operacao operacao;

    @ManyToOne
    @JoinColumn(name = "lider_id")
    private Lider lider;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    public DiariaRegistrada() {}

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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
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
}
