package com.example.controledepresenca.repository;

import com.example.controledepresenca.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer> {
	
    List<Relatorio> findByColaborador_NomeColaborador(String nome);
    
    List<Relatorio> findByColaborador_CpfColaborador(String cpf);
    
	List<Relatorio> findByLider_NomeLider(String nome);

	List<Relatorio> findByLider_cpfLider(String cpf);
}

