package com.example.controledepresenca.model;

import javax.persistence.*;

@Entity
@Table
public enum StatusAprovacao {
    PENDENTE,
    APROVADO,
    REJEITADO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    private Long id;
}