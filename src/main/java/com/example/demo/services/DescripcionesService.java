package com.example.demo.services;

import com.example.demo.models.Descripciones;
import com.example.demo.repositories.DescripcionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescripcionesService {
    private final DescripcionesRepository repository;

    public DescripcionesService(DescripcionesRepository repository) {
        this.repository = repository;
    }

    public List<Descripciones> getAll() {
        return repository.findAll();
    }
}
