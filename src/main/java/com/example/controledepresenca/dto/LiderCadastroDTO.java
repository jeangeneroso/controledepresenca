package com.example.controledepresenca.dto;

public class LiderCadastroDTO {

    private Integer id;
    private String nomeLider;
    private String rgLider;
    private String cpfLider;
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
