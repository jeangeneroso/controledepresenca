package com.example.controledepresenca.dto;

public class ColaboradorCadastroDTO {

    private Integer id;
    private String nomeColaborador;
    private String rgColaborador;
    private String cpfColaborador;
    private String chavePix;

    public ColaboradorCadastroDTO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
