package com.example.demo.services;

import com.example.demo.models.Galeria;
import com.example.demo.repositories.GaleriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GaleriaService {
    private final GaleriaRepository repository;

    public GaleriaService(GaleriaRepository repository) {
        this.repository = repository;
    }

    public List<Galeria> getAll() {
        return repository.findAll();
    }
}
