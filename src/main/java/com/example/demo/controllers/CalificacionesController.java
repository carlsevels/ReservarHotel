package com.example.demo.controllers;

import com.example.demo.models.Calificaciones;
import com.example.demo.services.CalificacionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificacioness")
public class CalificacionesController {
    private final CalificacionesService service;

    public CalificacionesController(CalificacionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Calificaciones> getAll() {
        return service.getAll();
    }
}
