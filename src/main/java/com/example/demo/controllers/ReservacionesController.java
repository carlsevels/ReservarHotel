package com.example.demo.controllers;

import com.example.demo.models.Reservaciones;
import com.example.demo.services.ReservacionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservacioness")
public class ReservacionesController {
    private final ReservacionesService service;

    public ReservacionesController(ReservacionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservaciones> getAll() {
        return service.getAll();
    }
}
