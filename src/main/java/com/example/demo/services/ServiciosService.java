package com.example.demo.services;

import com.example.demo.models.Servicios;
import com.example.demo.repositories.ServiciosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosService {
    private final ServiciosRepository repository;

    public ServiciosService(ServiciosRepository repository) {
        this.repository = repository;
    }

    public List<Servicios> getAll() {
        return repository.findAll();
    }
}
