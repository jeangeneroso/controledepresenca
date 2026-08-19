package com.example.controledepresenca.service;

import com.example.controledepresenca.model.DiariaRegistrada;
import com.example.controledepresenca.repository.DiariaRegistradaRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DiariaRegistradaService {

    private final DiariaRegistradaRepository repository;

    public DiariaRegistradaService(DiariaRegistradaRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "diarias", unless = "#result == null || #result.isEmpty()")
    public List<DiariaRegistrada> listarTodos() {
        List<DiariaRegistrada> lista = repository.findAll();
        return lista != null ? lista : List.of();
    }

    @CacheEvict(value = "diarias", allEntries = true)
    public void excluir(Integer id) {

        DiariaRegistrada diariaRegistrada = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Operacao não cadastrada "));
        repository.delete(diariaRegistrada);

    }


}
