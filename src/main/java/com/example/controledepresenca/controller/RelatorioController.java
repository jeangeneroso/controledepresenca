package com.example.controledepresenca.controller;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/colaborador")
    public List<Colaborador> getColaborador () {
        return relatorioService.getColaborador();
    }

    @GetMapping("/lider")
    public List<Lider> getLider () {
        return relatorioService.getLider();
    }


}
