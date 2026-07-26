package com.example.controledepresenca.controller;

import java.util.List;

import com.example.controledepresenca.dto.LiderCadastroDTO;
import com.example.controledepresenca.dto.OperacaoDTO;
import com.example.controledepresenca.model.Lider;
import org.springframework.web.bind.annotation.*;
import com.example.controledepresenca.model.Operacao;
import com.example.controledepresenca.service.OperacaoService;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
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
	public Operacao criar(@RequestBody @Valid Operacao operacao) {
		return operacaoService.salvar(operacao);
	}

	@PutMapping("/{id}")
	public Operacao atualizar (@PathVariable Integer id, @RequestBody @Valid Operacao operacao) {
		return operacaoService.atualizar(id, operacao);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		operacaoService.excluir(id);
	}

}
