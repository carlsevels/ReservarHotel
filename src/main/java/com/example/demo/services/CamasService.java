package com.example.demo.services;

import com.example.demo.models.Camas;
import com.example.demo.repositories.CamasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamasService {
    private final CamasRepository repository;

    public CamasService(CamasRepository repository) {
        this.repository = repository;
    }

    public List<Camas> getAll() {
        return repository.findAll();
    }
}
