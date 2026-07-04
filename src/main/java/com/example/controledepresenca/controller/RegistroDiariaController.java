package com.example.controledepresenca.controller;

import com.example.controledepresenca.dto.RegistroDiariaColaboradorDTO;
import com.example.controledepresenca.dto.RegistroDiariaLiderDTO;
import com.example.controledepresenca.model.RegistroDiariaColaborador;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledepresenca.model.RegistroDiariaLider;
import com.example.controledepresenca.service.RegistroDiariaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/presencas")
@CrossOrigin(origins = "*")
public class RegistroDiariaController {
	
	private final RegistroDiariaService presencaService;
	
	public RegistroDiariaController(RegistroDiariaService presencaService) {
		this.presencaService = presencaService;
	}

    // Registrar presença de colaborador
    @PostMapping("/colaborador")
    public RegistroDiariaColaborador incluirPresencaColaborador(
            @RequestBody RegistroDiariaColaboradorDTO dto) {
        return presencaService.incluirPresencaColaborador(dto);
    }


    // Registrar presença de líder
    @PostMapping("/lider")
    public RegistroDiariaLider incluirPresencaLider(
            @RequestBody RegistroDiariaLiderDTO dto) {
        return presencaService.incluirPresencaLider(dto);
    }
}
