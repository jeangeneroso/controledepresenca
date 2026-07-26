package com.example.controledepresenca.controller;

import java.util.List;

import com.example.controledepresenca.dto.LiderCadastroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.service.LiderService;

import javax.validation.Valid;

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
	public Lider getPorId (@PathVariable @Valid Integer id) {
		return liderService.listarPorId(id);
	}
	
	
	@PostMapping
	public ResponseEntity<Lider> criar (@RequestBody LiderCadastroDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(liderService.salvar(dto));
	}
	

	@PutMapping("/{id}")
	public Lider atualizar (@PathVariable @Valid Integer id, @RequestBody LiderCadastroDTO dto) {
		return liderService.atualizar(id, dto);
	}
	
	
	@DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        liderService.excluir(id);
    }
	
}
