package com.example.controledepresenca.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledepresenca.dto.RegistroDiariaDTO;
import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.RegistroDiaria;
import com.example.controledepresenca.service.ColaboradorService;
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
    @PostMapping("/{colaboradorId}")
    public RegistroDiaria incluirPresencaColaborador(
            @PathVariable Integer colaboradorId,
            @RequestBody RegistroDiaria presenca) {
        return presencaService.incluirPresencaColaborador(colaboradorId, presenca);
    }

    // Registrar presença de líder
    @PostMapping("/lider/{liderId}")
    public RegistroDiaria incluirPresencaLider(
            @PathVariable Integer liderId,
            @RequestBody RegistroDiaria presenca) {
        return presencaService.incluirPresencaLider(liderId, presenca);
    }


}
