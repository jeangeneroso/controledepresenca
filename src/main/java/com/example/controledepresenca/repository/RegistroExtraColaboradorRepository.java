package com.example.controledepresenca.repository;

import com.example.controledepresenca.model.RegistroExtraColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroExtraColaboradorRepository extends JpaRepository<RegistroExtraColaborador, Integer> {

    RegistroExtraColaborador save(RegistroExtraColaborador extra);
}
