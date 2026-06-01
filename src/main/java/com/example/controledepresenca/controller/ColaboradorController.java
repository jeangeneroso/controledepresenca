package com.example.controledepresenca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledepresenca.model.Colaborador;
import com.example.controledepresenca.service.ColaboradorService;


@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }
    
    @GetMapping
    public List<Colaborador> getTodos() {
        return colaboradorService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Colaborador getPorId(@PathVariable Integer id) {
        return colaboradorService.listarPorId(id);
    }
    
  /*  @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarPorId(@PathVariable Integer id) {
        try {
            Colaborador colaborador = service.listarPorId(id);
            return ResponseEntity.ok(colaborador);
        } catch (ColaboradorNaoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }
*/
       
   /* @GetMapping("/nome/{nome}")
    public List<Colaborador> buscarPorNome(@PathVariable String nomeColaborador) {
        return colaboradorService.buscarPorNome(nomeColaborador);
    }*/

    /*@PostMapping
    public Colaborador criar(@RequestBody Colaborador colaborador) {
        return colaboradorService.salvar(colaborador);
    }*/
    
    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Colaborador colaborador) {
        colaboradorService.salvar(colaborador);
        return ResponseEntity.ok(" Cadastro efetuado com sucesso! ");
    }

    /*@PutMapping("/{id}")
    public Colaborador atualizar(@PathVariable Integer id, @RequestBody Colaborador colaborador) {
        return colaboradorService.atualizar(id, colaborador);
    }*/
    
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Integer id, @RequestBody Colaborador colaborador) {
        colaboradorService.atualizar(id, colaborador);
        return ResponseEntity.ok(" Atualização realizada com sucesso! ");
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        colaboradorService.excluir(id);
        return ResponseEntity.ok(" Colaborador excluído com sucesso! ");
    }

}


