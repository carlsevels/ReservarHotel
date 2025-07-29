package com.example.demo.controllers;

import com.example.demo.models.Servicios;
import com.example.demo.services.ServiciosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {
    private final ServiciosService service;

    public ServiciosController(ServiciosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Servicios> getAll() {
        return service.getAll();
    }
}
