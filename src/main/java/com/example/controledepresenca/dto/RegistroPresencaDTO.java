package com.example.controledepresenca.dto;

import java.time.LocalDate;

import com.example.controledepresenca.model.RegistroPresenca;

public class RegistroPresencaDTO {
	
	    private String nomeColaborador;
	    private String nomeLider;
	    private LocalDate dia;
	    private String status;

	    public RegistroPresencaDTO(RegistroPresenca presenca) {
	        if (presenca.getColaborador() != null) {
	            this.nomeColaborador = presenca.getColaborador().getNomeColaborador();
	        }
	        if (presenca.getLider() != null) {
	            this.nomeLider = presenca.getLider().getNomeLider();
	        }
	        this.dia = presenca.getDia();
	        this.status = presenca.getStatus().name();
	    }

		public String getNomeColaborador() {
			return nomeColaborador;
		}

		public String getNomeLider() {
			return nomeLider;
		}

		public LocalDate getDia() {
			return dia;
		}

		public String getStatus() {
			return status;
		}

}
