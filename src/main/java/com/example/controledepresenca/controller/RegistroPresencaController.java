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

import com.example.controledepresenca.dto.RegistroPresencaDTO;
import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.RegistroPresenca;
import com.example.controledepresenca.service.ColaboradorService;
import com.example.controledepresenca.service.RegistroPresencaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/presencas")
public class RegistroPresencaController {
	
	private final RegistroPresencaService presencaService;
	
	public RegistroPresencaController (RegistroPresencaService presencaService) {
		this.presencaService = presencaService;
	}

	/* @GetMapping
	    public List<Presenca> getTodos() {
	        return presencaService.listarTodos();
	    }*/
	  
	// Listar todas as presenças
    @GetMapping
    public List<RegistroPresencaDTO> getTodos() {
        return presencaService.listarTodos()
                .stream()
                .map(RegistroPresencaDTO::new) // transforma entidade em DTO
                .collect(Collectors.toList());
    }
    
 // Listar presenças de um colaborador específico
    @GetMapping("/colaborador/{colaboradorId}")
    public List<RegistroPresencaDTO> getPresencasPorColaborador(@PathVariable Integer colaboradorId) {
        return presencaService.listarPorColaborador(colaboradorId)
                .stream()
                .map(RegistroPresencaDTO::new)
                .collect(Collectors.toList());
    }

    // Listar presenças de um líder específico
    @GetMapping("/lider/{liderId}")
    public List<RegistroPresencaDTO> getPresencasPorLider(@PathVariable Integer liderId) {
        return presencaService.listarPorLider(liderId)
                .stream()
                .map(RegistroPresencaDTO::new)
                .collect(Collectors.toList());
    }

    // Registrar presença de colaborador
    @PostMapping("/{colaboradorId}")
    public RegistroPresenca incluirPresencaColaborador(
            @PathVariable Integer colaboradorId,
            @RequestBody RegistroPresenca presenca) {
        return presencaService.incluirPresencaColaborador(colaboradorId, presenca);
    }

    // Registrar presença de líder
    @PostMapping("/lider/{liderId}")
    public RegistroPresenca incluirPresencaLider(
            @PathVariable Integer liderId,
            @RequestBody RegistroPresenca presenca) {
        return presencaService.incluirPresencaLider(liderId, presenca);
    }


}
