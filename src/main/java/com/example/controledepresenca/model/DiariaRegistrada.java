package com.example.controledepresenca.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diarias_registradas")
public class DiariaRegistrada {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_diarias_registradas")
    @SequenceGenerator(
            name = "seq_diarias_registradas",
            sequenceName = "seq_diarias_registradas",
            allocationSize = 1
    )
    private Integer id;

    private LocalDate dataDiaria;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "lider_id")
    private Lider lider;

    @ManyToOne
    @JoinColumn(name = "operacao_id")
    private Operacao operacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusAprovacao status = StatusAprovacao.APROVADO;

    public DiariaRegistrada() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataDiaria() {
        return dataDiaria;
    }

    public void setDataDiaria(LocalDate dataDiaria) {
        this.dataDiaria = dataDiaria;
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

    public StatusAprovacao getStatus() {
        return status;
    }

    public void setStatus(StatusAprovacao status) {
        this.status = status;
    }
}
