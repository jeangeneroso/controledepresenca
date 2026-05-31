package com.example.controledepresenca.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.service.ColaboradorService;
import com.example.controledepresenca.service.LiderService;

@RestController
@RequestMapping("/lideres")
public class LiderController {
	
	private final LiderService liderService;
	
	public LiderController(LiderService liderService) {
		this.liderService = liderService;
		
	}
	
	@GetMapping
	public List<Lider> getTodos(){
		return liderService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public Lider getPorId (@PathVariable Integer id) {
		return liderService.listTodosPorId(id);
	}
	
	
	@PostMapping
	public Lider criar (@RequestBody Lider lider) {
		return liderService.salvar(lider);	
	}
	

	@PutMapping("/{id}")
	public Lider atualizar (@PathVariable Integer id, @RequestBody Lider lider) {
		return liderService.atualizar(id, lider);		
	}
	
	
	@DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        liderService.excluir(id);
    }
	
}
