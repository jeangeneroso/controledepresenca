package com.example.controledepresenca.repository;

import com.example.controledepresenca.model.RegistroExtraLider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroExtraLiderRepository extends JpaRepository<RegistroExtraLider, Integer> {

    RegistroExtraLider save(RegistroExtraLider extra);
}
