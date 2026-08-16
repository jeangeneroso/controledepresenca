package com.example.controledepresenca.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "aprovacoes")
public class Aprovacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_aprovacoes")
    @SequenceGenerator(
            name = "seq_aprovacoes",
            sequenceName = "seq_aprovacoes",
            allocationSize = 1
    )
    private Integer id;

    // Quem é o usuário que está aprovando/rejeitando
    private String aprovador;

    // A data e hora exata em que o botão foi clicado
    private LocalDateTime dataAprovacao;

    // Um campo para o chefe escrever o motivo caso rejeite a diária
    private String justificativa;

    // O status atual (utilizando o Enum que criamos)
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusAprovacao status = StatusAprovacao.PENDENTE;

    @ManyToOne
    @JoinColumn(name = "registro_diaria_colaborador")
    private RegistroDiariaColaborador registroDiariaColaborador;

    @ManyToOne
    @JoinColumn(name = "registro_diaria_lider")
    private RegistroDiariaLider registroDiariaLider;

    @ManyToOne
    @JoinColumn(name = "registro_extra_colaborador")
    private RegistroExtraColaborador registroExtraColaborador;

    @ManyToOne
    @JoinColumn(name = "registro_extra_colaborador")
    private RegistroDiariaLider registroExtraLider;

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

    public LocalDateTime getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(LocalDateTime dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
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

    public RegistroDiariaColaborador getRegistroDiariaColaborador() {
        return registroDiariaColaborador;
    }

    public void setRegistroDiariaColaborador(RegistroDiariaColaborador registroDiariaColaborador) {
        this.registroDiariaColaborador = registroDiariaColaborador;
    }

    public RegistroDiariaLider getRegistroDiariaLider() {
        return registroDiariaLider;
    }

    public void setRegistroDiariaLider(RegistroDiariaLider registroDiariaLider) {
        this.registroDiariaLider = registroDiariaLider;
    }

    public RegistroExtraColaborador getRegistroExtraColaborador() {
        return registroExtraColaborador;
    }

    public void setRegistroExtraColaborador(RegistroExtraColaborador registroExtraColaborador) {
        this.registroExtraColaborador = registroExtraColaborador;
    }

    public RegistroDiariaLider getRegistroExtraLider() {
        return registroExtraLider;
    }

    public void setRegistroExtraLider(RegistroDiariaLider registroExtraLider) {
        this.registroExtraLider = registroExtraLider;
    }
}
