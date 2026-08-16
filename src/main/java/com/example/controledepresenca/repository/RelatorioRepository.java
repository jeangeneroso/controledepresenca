package com.example.controledepresenca.repository;

import com.example.controledepresenca.dto.RelatorioDTO;
import com.example.controledepresenca.dto.RelatorioFiltroDTO;
import com.example.controledepresenca.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Integer> {
	
    List<Relatorio> findByColaborador_NomeColaborador(String nomeColaborador);
    
    List<Relatorio> findByColaborador_CpfColaborador(String cpfColaborador);
    
	List<Relatorio> findByLider_NomeLider(String nomeLider);

	List<Relatorio> findByLider_cpfLider(String cpfLider);

    List <RelatorioFiltroDTO> findByData (String data);
}

