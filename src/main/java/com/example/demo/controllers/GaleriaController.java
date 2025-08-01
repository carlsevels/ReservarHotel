package com.example.demo.controllers;

import com.example.demo.models.Galeria;
import com.example.demo.services.GaleriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/galerias")
public class GaleriaController {
    private final GaleriaService service;

    public GaleriaController(GaleriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Galeria> getAll() {
        return service.getAll();
    }
}
