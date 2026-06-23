package com.example.controledepresenca.controller;

public class DiariaRegistradaController {
	
	/* @GetMapping
    public List<Presenca> getTodos() {
        return presencaService.listarTodos();
    }*/
  
// Listar todas as presenças
/*    @GetMapping
public List<RegistroDiariaDTO> getTodos() {
    return presencaService.listarTodos()
            .stream()
            .map(RegistroDiariaDTO::new) // transforma entidade em DTO
            .collect(Collectors.toList());
}*/

// Listar presenças de um colaborador específico
/*    @GetMapping("/colaborador/{colaboradorId}")
public List<RegistroDiariaDTO> getPresencasPorColaborador(@PathVariable Integer colaboradorId) {
    return presencaService.listarPorColaborador(colaboradorId)
            .stream()
            .map(RegistroDiariaDTO::new)
            .collect(Collectors.toList());
}*/

// Listar presenças de um líder específico
/*    @GetMapping("/lider/{liderId}")
public List<RegistroDiariaDTO> getPresencasPorLider(@PathVariable Integer liderId) {
    return presencaService.listarPorLider(liderId)
            .stream()
            .map(RegistroDiariaDTO::new)
            .collect(Collectors.toList());
}*/


}
