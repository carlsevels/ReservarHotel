package com.example.demo.controllers;

import com.example.demo.models.Camas;
import com.example.demo.services.CamasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camass")
public class CamasController {
    private final CamasService service;

    public CamasController(CamasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Camas> getAll() {
        return service.getAll();
    }
}
