package com.example.controledepresenca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.controledepresenca.model.RegistroDiaria;

@Repository
public interface RegistroDiariaRepository extends JpaRepository<RegistroDiaria, Integer> {

	RegistroDiaria save(RegistroDiaria presenca);

}
