package com.example.demo.controllers;

import com.example.demo.models.Fechas;
import com.example.demo.services.FechasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fechass")
public class FechasController {
    private final FechasService service;

    public FechasController(FechasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fechas> getAll() {
        return service.getAll();
    }
}
