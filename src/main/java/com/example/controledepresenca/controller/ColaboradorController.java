package com.example.controledepresenca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Colaborador criar(@RequestBody Colaborador colaborador) {
        return colaboradorService.salvar(colaborador);
    }

    @PutMapping("/{id}")
    public Colaborador atualizar(@PathVariable Integer id, @RequestBody Colaborador colaborador) {
        return colaboradorService.atualizar(id, colaborador);
    }
    
    /*@PutMapping("/lista")
    public List<Colaborador> atualizarLista(@RequestBody List<Colaborador> colaboradores) {
        return colaboradorService.atualizarTodos(colaboradores);
    }*/

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        colaboradorService.excluir(id);
    }
}


