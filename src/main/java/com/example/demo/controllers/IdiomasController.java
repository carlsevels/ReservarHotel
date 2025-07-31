package com.example.demo.controllers;

import com.example.demo.models.Idiomas;
import com.example.demo.services.IdiomasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/idiomass")
public class IdiomasController {
    private final IdiomasService service;

    public IdiomasController(IdiomasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Idiomas> getAll() {
        return service.getAll();
    }
}
