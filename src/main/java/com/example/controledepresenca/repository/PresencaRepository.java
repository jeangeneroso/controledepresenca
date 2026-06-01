package com.example.controledepresenca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.controledepresenca.model.Presenca;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Integer> {

	List<Presenca> findAll();

	List<Presenca> findByColaboradorId(Integer colaboradorId);

	List<Presenca> findByLiderId(Integer liderId);

	Presenca save(Presenca presenca);

}
