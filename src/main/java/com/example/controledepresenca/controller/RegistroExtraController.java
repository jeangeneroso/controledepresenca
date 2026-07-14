package com.example.controledepresenca.controller;

import com.example.controledepresenca.dto.RegistroExtraColaboradorDTO;
import com.example.controledepresenca.dto.RegistroExtraLiderDTO;
import com.example.controledepresenca.service.RegistroExtraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/extras")
@CrossOrigin(origins = "*")
public class RegistroExtraController {

    private final RegistroExtraService extraService;

    public RegistroExtraController (RegistroExtraService extraService){
        this.extraService = extraService;
    }

    @PostMapping("/colaborador")
    public ResponseEntity<RegistroExtraColaboradorDTO> incluirExtraColaborador(
            @RequestBody RegistroExtraColaboradorDTO dto) {

        extraService.incluirExtraColaborador(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PostMapping("/lider")
    public ResponseEntity<RegistroExtraLiderDTO> incluirExtraLider(
            @RequestBody RegistroExtraLiderDTO dto) {

        extraService.incluirExtraLider(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
