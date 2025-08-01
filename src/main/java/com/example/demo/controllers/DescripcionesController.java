package com.example.demo.controllers;

import com.example.demo.models.Descripciones;
import com.example.demo.services.DescripcionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/descripcioness")
public class DescripcionesController {
    private final DescripcionesService service;

    public DescripcionesController(DescripcionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Descripciones> getAll() {
        return service.getAll();
    }
}
