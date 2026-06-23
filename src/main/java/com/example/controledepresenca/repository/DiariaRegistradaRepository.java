package com.example.controledepresenca.repository;

public interface DiariaRegistradaRepository {

}

package com.example.controledepresenca.controller;

import com.example.controledepresenca.model.DiariaRegistrada;
import com.example.controledepresenca.repository.DiariaRegistradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/diarias") // Já mapeado com o prefixo /api que seu proxy espera
@CrossOrigin(origins = "*")
public class DiariaRegistradaController {

    @Autowired
    private DiariaRegistradaRepository diariaRepository;

    // 1. MÉTODO PARA LISTAR TODAS AS DIÁRIAS
    @GetMapping
    public List<DiariaRegistrada> listarTodas() {
        return diariaRepository.findAll();
    }

    // 2. MÉTODO PARA SALVAR A DIÁRIA (Trata Líder e Colaborador)
    @PostMapping
    public ResponseEntity<DiariaRegistrada> salvar(@RequestBody DiariaRegistrada diaria) {

        // Lógica para definir a função dinamicamente antes de salvar no banco
        if (diaria.getLider() != null && diaria.getLider().getId() != null) {
            diaria.setFuncao("LIDER");
            diaria.setColaborador(null); // Garante que não salve lixo no campo oposto
        } else if (diaria.getColaborador() != null && diaria.getColaborador().getId() != null) {
            diaria.setFuncao("COLABORADOR");
            diaria.setLider(null); // Garante que não salve lixo no campo oposto
        } else {
            // Se não enviou nem líder nem colaborador, retorna erro de requisição ruim
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        // Salva no banco de dados e retorna o objeto salvo com o ID gerado
        DiariaRegistrada diariaSalva = diariaRepository.save(diaria);
        return ResponseEntity.status(HttpStatus.CREATED).body(diariaSalva);
    }
}
