package com.example.controledepresenca.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiderCadastroDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nomeLider")
    private String nomeLider;

    @JsonProperty("rgLider")
    private String rgLider;

    @JsonProperty("cpfLider")
    private String cpfLider;

    @JsonProperty("chavePix")
    private String chavePix;

    public LiderCadastroDTO (){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeLider() {
        return nomeLider;
    }

    public void setNomeLider(String nomeLider) {
        this.nomeLider = nomeLider;
    }

    public String getRgLider() {
        return rgLider;
    }

    public void setRgLider(String rgLider) {
        this.rgLider = rgLider;
    }

    public String getCpfLider() {
        return cpfLider;
    }

    public void setCpfLider(String cpfLider) {
        this.cpfLider = cpfLider;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
