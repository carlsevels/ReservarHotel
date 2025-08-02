package com.example.demo.services;

import com.example.demo.models.Reservaciones;
import com.example.demo.repositories.ReservacionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservacionesService {
    private final ReservacionesRepository repository;

    public ReservacionesService(ReservacionesRepository repository) {
        this.repository = repository;
    }

    public List<Reservaciones> getAll() {
        return repository.findAll();
    }
}
