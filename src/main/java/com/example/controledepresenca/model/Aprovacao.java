package com.example.controledepresenca.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aprovacoes")
public class Aprovacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Quem é o usuário que está aprovando/rejeitando
    private String aprovador;

    // A data e hora exata em que o botão foi clicado
    private LocalDateTime dataAprovacao;

    // Um campo para o chefe escrever o motivo caso rejeite a diária
    private String justificativa;

    // O status atual (utilizando o Enum que criamos)
    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusAprovacao status;

    @ManyToOne
    @JoinColumn(name = "registro_diaria_id")
    private RegistroDiaria registroDiaria;

    public Aprovacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAprovador() {
        return aprovador;
    }

    public void setAprovador(String aprovador) {
        this.aprovador = aprovador;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAprovacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAprovacao = dataAvaliacao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public StatusAprovacao getStatus() {
        return status;
    }

    public void setStatus(StatusAprovacao status) {
        this.status = status;
    }

    public RegistroDiaria getRegistroDiaria() {
        return registroDiaria;
    }

    public void setRegistroDiaria(RegistroDiaria registroDiaria) {
        this.registroDiaria = registroDiaria;
    }
}
