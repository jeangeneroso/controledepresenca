package com.example.controledepresenca.repository;

import com.example.controledepresenca.model.RegistroDiariaColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroDiariaColaboradorRepository extends JpaRepository<RegistroDiariaColaborador, Integer> {

	RegistroDiariaColaborador save(RegistroDiariaColaborador presenca);

}
