package com.example.demo.services;

import com.example.demo.models.Fechas;
import com.example.demo.repositories.FechasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FechasService {
    private final FechasRepository repository;

    public FechasService(FechasRepository repository) {
        this.repository = repository;
    }

    public List<Fechas> getAll() {
        return repository.findAll();
    }
}
