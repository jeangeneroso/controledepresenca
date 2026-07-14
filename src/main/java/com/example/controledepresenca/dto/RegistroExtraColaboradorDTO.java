package com.example.controledepresenca.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistroExtraColaboradorDTO {

    @JsonProperty("colaborador")
    private ColaboradorCadastroDTO colaborador;

    @JsonProperty("operacao")
    private OperacaoDTO operacao;

    @JsonProperty("data")
    @JsonFormat(pattern = "yyyy-MM-dd['T'HH:mm:ss.SSS'Z']")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate data;

    @JsonProperty("hora")
    private Integer quantidadeHoras;

    public RegistroExtraColaboradorDTO (){

    }

    public ColaboradorCadastroDTO getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorCadastroDTO colaborador) {
        this.colaborador = colaborador;
    }

    public OperacaoDTO getOperacao() {
        return operacao;
    }

    public void setOperacao(OperacaoDTO operacao) {
        this.operacao = operacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Integer quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
}
