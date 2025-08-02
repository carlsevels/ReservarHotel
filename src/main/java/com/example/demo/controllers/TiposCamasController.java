package com.example.demo.controllers;

import com.example.demo.models.TiposCamas;
import com.example.demo.services.TiposCamasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tiposCamass")
public class TiposCamasController {
    private final TiposCamasService service;

    public TiposCamasController(TiposCamasService service) {
        this.service = service;
    }

    @GetMapping
    public List<TiposCamas> getAll() {
        return service.getAll();
    }
}
