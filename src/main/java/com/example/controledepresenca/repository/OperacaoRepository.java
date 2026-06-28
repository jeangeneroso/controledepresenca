package com.example.controledepresenca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.controledepresenca.model.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Integer> {

	List<Operacao> findAll();

	Optional<Operacao> findById(Integer id);

	void delete(Operacao operacao);

}
