package com.example.controledepresenca.controller;


import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.DiariaRegistrada;
import com.example.controledepresenca.service.DiariaRegistradaService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@CrossOrigin(origins = "*")
@Validated
@RestController
@RequestMapping("/diarias")
public class DiariaRegistradaController {

    private final DiariaRegistradaService diariaRegistradaService;

    public DiariaRegistradaController (DiariaRegistradaService diariaRegistradaService){
        this.diariaRegistradaService = diariaRegistradaService;
    }

    @GetMapping
    public @ResponseBody List<DiariaRegistrada> getTodos() {
        return diariaRegistradaService.listarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable @NotNull @Positive Integer id) {
        diariaRegistradaService.excluir(id);
        return ResponseEntity.ok(" Diaria excluida com sucesso! ");
    }



}
