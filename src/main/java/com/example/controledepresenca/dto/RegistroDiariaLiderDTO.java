package com.example.controledepresenca.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistroDiariaLiderDTO {

	@JsonProperty("lider")
	private LiderCadastroDTO lider;

	@JsonProperty("operacao")
	private OperacaoDTO operacao;

	@JsonProperty("data")
	@JsonFormat(pattern = "yyyy-MM-dd['T'HH:mm:ss.SSS'Z']")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate data;

	public RegistroDiariaLiderDTO() {}

	public LiderCadastroDTO getLider() { return lider; }
	public void setLider(LiderCadastroDTO lider) { this.lider = lider; }

	public OperacaoDTO getOperacao() { return operacao; }
	public void setOperacao(OperacaoDTO operacao) { this.operacao = operacao; }

	public LocalDate getData() { return data; }
	public void setData(LocalDate data) { this.data = data; }
}