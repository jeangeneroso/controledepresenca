package com.example.controledepresenca.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.controledepresenca.model.Lider;

@Repository
public interface LiderRepository  extends JpaRepository<Lider, Integer> {

	List<Lider> findAll();

	Optional<Lider> findById(Integer id);

	void delete(Lider lider);

}
