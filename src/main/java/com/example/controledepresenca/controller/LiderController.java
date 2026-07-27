package com.example.controledepresenca.controller;

import java.util.List;

import com.example.controledepresenca.dto.LiderCadastroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.controledepresenca.model.Lider;
import com.example.controledepresenca.service.LiderService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@CrossOrigin(origins = "https://apicontroledepresenca.jean-generoso.workers.dev")
@RestController
@Validated
@RequestMapping({"/lideres", "/api/lideres"})
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
	public Lider getPorId (@PathVariable @Valid @NotNull @Positive Integer id) {
		return liderService.listarPorId(id);
	}
	
	
	@PostMapping
	public ResponseEntity<Lider> criar (@RequestBody LiderCadastroDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(liderService.salvar(dto));
	}
	

	@PutMapping("/{id}")
	public Lider atualizar (@PathVariable @Valid @NotNull @Positive Integer id, @RequestBody LiderCadastroDTO dto) {
		return liderService.atualizar(id, dto);
	}
	
	
	@DeleteMapping("/{id}")
    public void excluir(@PathVariable @NotNull @Positive Integer id) {
        liderService.excluir(id);
    }
	
}
