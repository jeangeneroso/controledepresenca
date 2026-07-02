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
    @PostMapping("/colaborador")
    public RegistroDiaria incluirPresencaColaborador(
            @RequestBody RegistroDiaria presenca) {
        return presencaService.incluirPresencaColaborador(presenca);
    }

    // Registrar presença de líder
    /*@PostMapping("/lider")
    public RegistroDiaria incluirPresencaLider(
            @RequestBody RegistroDiaria presenca) {
        return presencaService.incluirPresencaLider(presenca);
    }
*/

    @PostMapping("/lider")
    public RegistroDiaria incluirPresencaLider(@RequestBody RegistroDiaria presenca) {
        // Esse print vai te mostrar no console do IntelliJ exatamente o que o Java recebeu
        System.out.println("Objeto recebido: " + presenca);
        System.out.println("Líder dentro do objeto: " + presenca.getLider());

        return presencaService.incluirPresencaLider(presenca);
    }
}
