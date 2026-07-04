package com.example.controledepresenca.dto;

public class OperacaoDTO {

    private Integer id;
    private String nomeOperacaoDTO;

    public OperacaoDTO() {}

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNomeOperacaoDTO() {
        return nomeOperacaoDTO;
    }

    public void setNomeOperacaoDTO(String nomeOperacaoDTO) {
        this.nomeOperacaoDTO = nomeOperacaoDTO;
    }
}
