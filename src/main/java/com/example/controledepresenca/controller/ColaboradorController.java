package com.example.controledepresenca.controller;

import java.util.List;

import com.example.controledepresenca.dto.ColaboradorCadastroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.service.ColaboradorService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@CrossOrigin(origins = "https://apicontroledepresenca.jean-generoso.workers.dev")
@Validated
@RestController
@RequestMapping("/api/colaboradores")
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
    public @ResponseBody Colaborador getPorId(@PathVariable @NotNull @Positive Integer id) {
        return colaboradorService.listarPorId(id);
    }
        
    @PostMapping
    public ResponseEntity<Colaborador> criar(@RequestBody @Valid ColaboradorCadastroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorService.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizar(@PathVariable @Valid @NotNull @Positive Integer id, @RequestBody ColaboradorCadastroDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.atualizar(id, dto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable @NotNull @Positive Integer id) {
        colaboradorService.excluir(id);
        return ResponseEntity.ok(" Colaborador excluído com sucesso! ");
    }

}


