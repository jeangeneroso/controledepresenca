package com.example.controledepresenca.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledepresenca.model.RegistroDiaria;
import com.example.controledepresenca.service.RegistroDiariaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/presencas")
public class RegistroDiariaController {
	
	private final RegistroDiariaService presencaService;
	
	public RegistroDiariaController (RegistroDiariaService presencaService) {
		this.presencaService = presencaService;
	}

    // Registrar presença de colaborador
    @PostMapping("/colaboradorId")
    public RegistroDiaria incluirPresencaColaborador(
            @PathVariable Integer colaboradorId,
            @RequestBody RegistroDiaria presenca) {
        return presencaService.incluirPresencaColaborador(colaboradorId, presenca);
    }

    // Registrar presença de líder
    @PostMapping("/liderId")
    public RegistroDiaria incluirPresencaLider(
            @PathVariable Integer liderId,
            @RequestBody RegistroDiaria presenca) {
        return presencaService.incluirPresencaLider(liderId, presenca);
    }


}
