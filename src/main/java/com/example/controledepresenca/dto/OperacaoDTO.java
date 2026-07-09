package com.example.controledepresenca.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OperacaoDTO {

    // Alinhado com o getId() e setId() e com o JSON que vem do Front-End
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