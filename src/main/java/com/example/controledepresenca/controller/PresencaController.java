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

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class PresencaController {
	
    @PostMapping("/{id}/presenca")
    public Presenca incluirPresencaColabodor(@PathVariable Integer id, @RequestBody Date dataPresenca) {
        return presencaService.incluirPresenca(id, dataPresenca);
    }
    
    @PostMapping("/{id}/presenca")
    public Presenca incluirPresencaLider(@PathVariable Integer id, @RequestBody Date dataPresenca) {
        return presencaService.incluirPresenca(id, dataPresenca);
    }


}
