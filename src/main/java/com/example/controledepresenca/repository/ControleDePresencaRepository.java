package com.example.controledepresenca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.controledepresenca.model.Colaborador;


@Repository
public interface ControleDePresencaRepository extends JpaRepository <Colaborador, Integer > {
	List <Colaborador> findAll();

}


/*@Repository
public interface ControleDePresencaRepository extends JpaRepository<Colaborador, Integer> {
    // Não precisa declarar findAll(), já vem do JpaRepository
}
*/

/*@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {
    // Aqui você pode adicionar consultas customizadas se precisar
}*/
