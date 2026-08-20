package com.example.controledepresenca.controller;

import com.example.controledepresenca.dto.RegistroDiariaColaboradorDTO;
import com.example.controledepresenca.dto.RegistroDiariaLiderDTO;
import com.example.controledepresenca.model.StatusAprovacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.controledepresenca.service.RegistroDiariaService;

import java.util.List;


@RestController
@RequestMapping("/presencas")
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

   /* // Listar diárias pendentes (Para a tela de Aprovação)
    @GetMapping("/pendentes")
    public List<RegistroDiariaLiderDTO> listarPendentes() {
        return RegistroDiariaService.buscarPendentes();
    }

    // Alterar o Status (Aprovar ou Rejeitar)
    @PatchMapping("/{id}/status")
    public Diaria alterarStatus(@PathVariable Long id, @RequestParam StatusAprovacao status) {
        return diariaService.atualizarStatus(id, status);
    }*/

}
