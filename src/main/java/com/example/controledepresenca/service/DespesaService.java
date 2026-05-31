package com.example.controledepresenca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controledepresenca.repository.ControleDePresencaRepository;


@RestController
public class DespesaService {
	
	@Autowired
	private ControleDePresencaRepository repository;
	
/*	@GetMapping("/despesas")
	public List<Despesa> getDespesas(){
		return repository.findAll();
		
	}*/

}

/*@Service
public class ColaboradorService {

    private final ColaboradorRepository repository;

    public ColaboradorService(ColaboradorRepository repository) {
        this.repository = repository;
    }

    // Listar todos
    public List<Colaborador> listarTodos() {
        return repository.findAll();
    }

    // Listar apenas um
    public Colaborador listarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador não encontrado"));
    }

    // Inclusão de um
    public Colaborador salvar(Colaborador colaborador) {
        if (colaborador.getNomeColaborador() == null || colaborador.getNomeColaborador().isBlank()) {
            throw new IllegalArgumentException("Nome do colaborador é obrigatório");
        }
        return repository.save(colaborador);
    }

    // Inclusão de todos (lista)
    public List<Colaborador> salvarTodos(List<Colaborador> colaboradores) {
        return repository.saveAll(colaboradores);
    }

    // Alteração de um
    public Colaborador atualizar(Integer id, Colaborador dadosAtualizados) {
        Colaborador colaborador = listarPorId(id);
        colaborador.setNomeColaborador(dadosAtualizados.getNomeColaborador());
        colaborador.setChavePix(dadosAtualizados.getChavePix());
        colaborador.setRodizio(dadosAtualizados.getRodizio());
        colaborador.setDataPresenca(dadosAtualizados.getDataPresenca());
        return repository.save(colaborador);
    }

    // Alteração de todos
    public List<Colaborador> atualizarTodos(List<Colaborador> colaboradores) {
        return repository.saveAll(colaboradores);
    }

    // Exclusão de um
    public void excluir(Integer id) {
        Colaborador colaborador = listarPorId(id);
        repository.delete(colaborador);
    }
}

*/
