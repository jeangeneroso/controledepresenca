package com.example.controledepresenca.controller;

import java.util.List;

import com.example.controledepresenca.dto.ColaboradorCadastroDTO;
import com.example.controledepresenca.dto.LiderCadastroDTO;
import com.example.controledepresenca.model.Lider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.service.ColaboradorService;


@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }
    
    @GetMapping
    public @ResponseBody List<Colaborador> getTodos() {
        return colaboradorService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public @ResponseBody Colaborador getPorId(@PathVariable Integer id) {
        return colaboradorService.listarPorId(id);
    }
        
    @PostMapping
    public ResponseEntity<Colaborador> criar(@RequestBody ColaboradorCadastroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizar(@PathVariable Integer id, @RequestBody ColaboradorCadastroDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.atualizar(id, dto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        colaboradorService.excluir(id);
        return ResponseEntity.ok(" Colaborador excluído com sucesso! ");
    }

}


