package com.example.controledepresenca.service;


import com.example.controledepresenca.model.Relatorio;
import com.example.controledepresenca.repository.RelatorioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RelatorioService {

    private final RelatorioRepository repository;

    public RelatorioService(RelatorioRepository repository) {
        this.repository = repository;
    }

   public List<Relatorio> ListarTodos() {
        return repository.findAll();
    }

    public List<Relatorio> buscarPorNomeColaborador(String nome) {
    	if(nome == null) {
    		throw new IllegalArgumentException("Nome do Colaborador é obrigatório");
    	}
    	
        return repository.findByColaborador_NomeColaborador(nome);
    }
    
    
    public List<Relatorio> buscarPorNomeLider(String nome) {
    	if(nome == null) {
    		throw new IllegalArgumentException("Nome do Lider é obrigatório");
    	}
        return repository.findByLider_NomeLider(nome);
    }

    public List<Relatorio> buscarPorCpfColaborador(String cpf) {
        return repository.findByColaborador_CpfColaborador(cpf);
    }
    
    public List<Relatorio> buscarPorCpfLider(String cpf) {
        return repository.findByLider_cpfLider(cpf);
    }

    // Filtrar por operação
    /*public List<Relatorio> buscarPorOperacao(String nomeOperacao) {
        return relatorioRepository.findByOperacao_Nome(nomeOperacao);
    }*/
    
   /* public List<Relatorio> buscarRelatorios(String nome, String cpf) {
        if (nome != null && !nome.isEmpty()) {
            return repository.findByColaborador_NomeColaborador(nome);
        } else if (cpf != null && !cpf.isEmpty()) {
            return repository.findByColaborador_CpfColaborador(cpf);
        } else {
            return repository.findAll();
        }
    }*/

}
