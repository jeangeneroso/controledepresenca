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

    @Cacheable("diarias")
    public List<DiariaRegistrada> listarTodos() {
        return null;
    }

    @CacheEvict(value = "diarias", allEntries = true)
    public void excluir(Integer id) {

        DiariaRegistrada diariaRegistrada = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Operacao não cadastrada "));
        repository.delete(diariaRegistrada);

    }


}
