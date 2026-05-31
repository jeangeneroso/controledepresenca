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

import com.example.controledepresenca.dto.PresencaDTO;
import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Presenca;
import com.example.controledepresenca.service.ColaboradorService;
import com.example.controledepresenca.service.PresencaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/presencas")
public class PresencaController {
	
	private final PresencaService presencaService;
	
	public PresencaController (PresencaService presencaService) {
		this.presencaService = presencaService;
	}

	/* @GetMapping
	    public List<Presenca> getTodos() {
	        return presencaService.listarTodos();
	    }*/
	  
	// Listar todas as presenças
    @GetMapping
    public List<PresencaDTO> getTodos() {
        return presencaService.listarTodos()
                .stream()
                .map(PresencaDTO::new) // transforma entidade em DTO
                .collect(Collectors.toList());
    }
    
 // Listar presenças de um colaborador específico
    @GetMapping("/colaborador/{colaboradorId}")
    public List<PresencaDTO> getPresencasPorColaborador(@PathVariable Integer colaboradorId) {
        return presencaService.listarPorColaborador(colaboradorId)
                .stream()
                .map(PresencaDTO::new)
                .collect(Collectors.toList());
    }

    // Listar presenças de um líder específico
    @GetMapping("/lider/{liderId}")
    public List<PresencaDTO> getPresencasPorLider(@PathVariable Integer liderId) {
        return presencaService.listarPorLider(liderId)
                .stream()
                .map(PresencaDTO::new)
                .collect(Collectors.toList());
    }

    // Registrar presença de colaborador
    @PostMapping("/{colaboradorId}")
    public Presenca incluirPresencaColaborador(
            @PathVariable Integer colaboradorId,
            @RequestBody Presenca presenca) {
        return presencaService.incluirPresencaColaborador(colaboradorId, presenca);
    }

    // Registrar presença de líder
    @PostMapping("/lider/{liderId}")
    public Presenca incluirPresencaLider(
            @PathVariable Integer liderId,
            @RequestBody Presenca presenca) {
        return presencaService.incluirPresencaLider(liderId, presenca);
    }


}
