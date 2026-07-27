package com.example.controledepresenca.controller;

import com.example.controledepresenca.dto.RegistroDiariaColaboradorDTO;
import com.example.controledepresenca.dto.RegistroDiariaLiderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.controledepresenca.service.RegistroDiariaService;


@RestController
@RequestMapping({"/presencas", "/api/presencas"})
@CrossOrigin(origins = "*")
public class RegistroDiariaController {
	
	private final RegistroDiariaService presencaService;
	
	public RegistroDiariaController(RegistroDiariaService presencaService) {
		this.presencaService = presencaService;
	}

    @PostMapping("/colaborador")
    public ResponseEntity<RegistroDiariaColaboradorDTO> incluirPresencaColaborador(
            @RequestBody RegistroDiariaColaboradorDTO dto) {

        presencaService.incluirPresencaColaborador(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/lider")
    public ResponseEntity<RegistroDiariaLiderDTO> incluirPresencaLider(
            @RequestBody RegistroDiariaLiderDTO dto) {

        presencaService.incluirPresencaLider(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    // Registrar presença de colaborador
   /* @PostMapping("/colaborador")
    public RegistroDiariaColaborador incluirPresencaColaborador(
            @RequestBody RegistroDiariaColaboradorDTO dto) {
        return presencaService.incluirPresencaColaborador(dto);
    }*/

    /*@PostMapping("/lider")
    public RegistroDiariaLider incluirPresencaLider(@RequestBody RegistroDiariaLiderDTO dto) {

        // --- LINHAS DE TESTE PARA IMPRIMIR NO CONSOLE DO SPRING ---
        System.out.println("==================================================");
        if (dto == null) {
            System.out.println("ERRO: O DTO inteiro chegou NULO!");
        } else {
            System.out.println("O DTO chegou. Verificando o objeto 'lider'...");
            System.out.println("Objeto Lider: " + dto.getLider());

            if (dto.getLider() != null) {
                System.out.println("ID do Líder recebido: " + dto.getLider().getId());
            } else {
                System.out.println("ERRO: O objeto 'lider' dentro do DTO está NULO!");
            }
        }
        System.out.println("==================================================");
        // ---------------------------------------------------------

        return presencaService.incluirPresencaLider(dto);
    }*/
}
