package com.example.controledepresenca.controller;

import java.util.List;

import com.example.controledepresenca.dto.ColaboradorCadastroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Colaborador> getTodos() {
        return colaboradorService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Colaborador getPorId(@PathVariable Integer id) {
        return colaboradorService.listarPorId(id);
    }
        
    @PostMapping
    public ResponseEntity<String> criar(@RequestBody ColaboradorCadastroDTO dto) {
        colaboradorService.salvar(dto);
        return ResponseEntity.ok(" Cadastro efetuado com sucesso! ");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Integer id, @RequestBody ColaboradorCadastroDTO dto) {
        colaboradorService.atualizar(id, dto);
        return ResponseEntity.ok(" Atualização realizada com sucesso! ");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        colaboradorService.excluir(id);
        return ResponseEntity.ok(" Colaborador excluído com sucesso! ");
    }

}


