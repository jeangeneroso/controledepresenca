package com.example.controledepresenca.controller;

import com.example.controledepresenca.model.Relatorio;
import com.example.controledepresenca.service.RelatorioService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }
    
    @GetMapping
    public List<Relatorio> getTodos() {
        return relatorioService.ListarTodos();
    }
    
    
/*    @GetMapping("/relatorios")
    public ResponseEntity<List<Relatorio>> buscarRelatorios(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf) {
        return ResponseEntity.ok(relatorioService.buscarRelatorios(nome, cpf));
    }
*/
       
}
