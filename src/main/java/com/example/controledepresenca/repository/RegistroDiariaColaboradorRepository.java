package com.example.controledepresenca.repository;

import com.example.controledepresenca.model.RegistroDiariaColaborador;
import com.example.controledepresenca.model.StatusAprovacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroDiariaColaboradorRepository extends JpaRepository<RegistroDiariaColaborador, Integer> {

	List<RegistroDiariaColaborador> findByStatus(StatusAprovacao status);

}
