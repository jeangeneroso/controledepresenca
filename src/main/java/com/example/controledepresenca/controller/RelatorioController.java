package com.example.controledepresenca.controller;

import com.example.controledepresenca.dto.RelatorioDTO;
import com.example.controledepresenca.dto.RelatorioFiltroDTO;
import com.example.controledepresenca.model.Relatorio;
import com.example.controledepresenca.service.RelatorioService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
@CrossOrigin(origins = "*")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }
    
    @GetMapping
    public List<Relatorio> getTodos() {
        return relatorioService.ListarTodos();
    }

    @GetMapping("/colaborador")
    public List <Relatorio> getPorNomeColaborador(RelatorioDTO dto) {
        return relatorioService.buscarPorNomeColaborador(dto);
    }

    @GetMapping("/lider")
    public List <Relatorio> getPorNomeLider(RelatorioDTO dto) {
        return relatorioService.buscarPorNomeLider(dto);
    }

    @GetMapping("/cpf_colaborador")
    public List <Relatorio> getPorCpfColaborador(RelatorioDTO dto) {
        return relatorioService.buscarPorCpfColaborador(dto);
    }

    @GetMapping("/cpf_lider")
    public List <Relatorio> getPorCpfLider(RelatorioDTO dto) {
        return relatorioService.buscarPorCpfLider(dto);
    }

    @GetMapping("/data")
    public List<RelatorioFiltroDTO> getPorData(@RequestParam("data") String data) {
        return relatorioService.buscarPorData(data);
    }

       
}
