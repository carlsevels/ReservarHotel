package com.example.demo.services;

import com.example.demo.models.Calificaciones;
import com.example.demo.repositories.CalificacionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionesService {
    private final CalificacionesRepository repository;

    public CalificacionesService(CalificacionesRepository repository) {
        this.repository = repository;
    }

    public List<Calificaciones> getAll() {
        return repository.findAll();
    }
}
