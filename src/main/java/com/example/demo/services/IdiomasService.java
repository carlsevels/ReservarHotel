package com.example.demo.services;

import com.example.demo.models.Idiomas;
import com.example.demo.repositories.IdiomasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomasService {
    private final IdiomasRepository repository;

    public IdiomasService(IdiomasRepository repository) {
        this.repository = repository;
    }

    public List<Idiomas> getAll() {
        return repository.findAll();
    }
}
