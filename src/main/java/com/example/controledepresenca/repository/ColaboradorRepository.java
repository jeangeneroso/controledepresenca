package com.example.controledepresenca.repository;

import java.util.List;
import java.util.Optional;

import com.example.controledepresenca.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

	List<Colaborador> findAll();
	
	Optional<Colaborador> findById(Integer id);
	
	void delete(Colaborador colaborador);

	boolean existsByCpf(String cpf);

	boolean existsByCpfAndIdNot(String cpf, Integer id);

}
