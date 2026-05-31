package com.example.controledepresenca.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	

}
