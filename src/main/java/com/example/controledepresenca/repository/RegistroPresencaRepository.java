package com.example.controledepresenca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.controledepresenca.model.RegistroPresenca;

@Repository
public interface RegistroPresencaRepository extends JpaRepository<RegistroPresenca, Integer> {

	List<RegistroPresenca> findAll();

	List<RegistroPresenca> findByColaboradorId(Integer colaboradorId);

	List<RegistroPresenca> findByLiderId(Integer liderId);

	RegistroPresenca save(RegistroPresenca presenca);

}
