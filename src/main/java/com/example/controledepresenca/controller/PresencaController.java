package com.example.controledepresenca.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	 @GetMapping
	    public List<Presenca> getTodos() {
	        return presencaService.listarTodos();
	    }
	
    @PostMapping("/{id}/presenca")
    public Presenca incluirPresencaColabodor(@PathVariable Integer id, @RequestBody Date dataPresenca) {
        return presencaService.incluirPresencaColaborador(id, dataPresenca);
    }
    
    @PostMapping("/{id}/presenca")
    public Presenca incluirPresencaLider(@PathVariable Integer id, @RequestBody Date dataPresenca) {
        return presencaService.incluirPresencaLider(id, dataPresenca);
    }


}
