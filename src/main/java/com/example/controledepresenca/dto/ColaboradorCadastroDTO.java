package com.example.controledepresenca.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColaboradorCadastroDTO {

    @JsonProperty("id")
    private Integer idColaborador;

    @JsonProperty("nomeColaborador")
    private String nomeColaborador;

    @JsonProperty("rgColaborador")
    private String rgColaborador;

    @JsonProperty("cpfColaborador")
    private String cpfColaborador;

    @JsonProperty("chavepixColaborador")
    private String chavePix;

    public ColaboradorCadastroDTO() {}

    public Integer getId() {
        return idColaborador;
    }

    public void setId(Integer id) {
        this.idColaborador = id;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public String getRgColaborador() {
        return rgColaborador;
    }

    public void setRgColaborador(String rgColaborador) {
        this.rgColaborador = rgColaborador;
    }

    public String getCpfColaborador() {
        return cpfColaborador;
    }

    public void setCpfColaborador(String cpfColaborador) {
        this.cpfColaborador = cpfColaborador;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }
}
