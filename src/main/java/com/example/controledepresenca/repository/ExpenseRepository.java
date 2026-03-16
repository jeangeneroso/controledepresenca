package com.example.controledepresenca.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExpenseRepository {
	
	@Autowired
	private ControleDePresencaRepository repository;

}
