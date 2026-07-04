package com.example.controledepresenca.repository;

import com.example.controledepresenca.model.RegistroDiariaColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.controledepresenca.model.RegistroDiariaLider;

@Repository
public interface RegistroDiariaLiderRepository extends JpaRepository<RegistroDiariaLider, Integer> {

	RegistroDiariaLider save(RegistroDiariaLider presenca);


}
