package com.example.demo.services;

import com.example.demo.models.Habitaciones;
import com.example.demo.repositories.HabitacionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionesService {
    private final HabitacionesRepository repository;

    public HabitacionesService(HabitacionesRepository repository) {
        this.repository = repository;
    }

    public List<Habitaciones> getAll() {
        return repository.findAll();
    }
}
