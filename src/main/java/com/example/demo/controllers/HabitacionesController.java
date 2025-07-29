package com.example.demo.controllers;

import com.example.demo.models.Habitaciones;
import com.example.demo.services.HabitacionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitacioness")
public class HabitacionesController {
    private final HabitacionesService service;

    public HabitacionesController(HabitacionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Habitaciones> getAll() {
        return service.getAll();
    }
}
