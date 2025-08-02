package com.example.demo.services;

import com.example.demo.models.TiposCamas;
import com.example.demo.repositories.TiposCamasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiposCamasService {
    private final TiposCamasRepository repository;

    public TiposCamasService(TiposCamasRepository repository) {
        this.repository = repository;
    }

    public List<TiposCamas> getAll() {
        return repository.findAll();
    }
}
