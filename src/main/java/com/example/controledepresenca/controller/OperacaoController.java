package com.example.controledepresenca.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.controledepresenca.model.Operacao;
import com.example.controledepresenca.service.OperacaoService;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {

	private final OperacaoService operacaoService;

	public OperacaoController(OperacaoService operacaoService) {
		this.operacaoService = operacaoService;
	}

	@GetMapping
	public List<Operacao> getTodos() {
		return operacaoService.listarTodos();
	}

	@GetMapping("/{id}")
	public @ResponseBody Operacao getPorId(@PathVariable Integer id) {
		return operacaoService.listarPorId(id);
	}


	@PostMapping
	public Operacao criar(@RequestBody Operacao operacao) {
		return operacaoService.salvar(operacao);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		operacaoService.excluir(id);
	}

}
