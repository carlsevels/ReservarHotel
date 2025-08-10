package com.example.demo.controllers;

import com.example.demo.DTO.CreateCalificacionesDTO;
import com.example.demo.DTO.EditCalificacionDTO;
import com.example.demo.models.Calificaciones;
import com.example.demo.repositories.CalificacionesRepository;
import com.example.demo.services.CalificacionesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionesController {
    private final CalificacionesService service;

    public CalificacionesController(CalificacionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Calificaciones> getAll() {
        return service.getAll();
    }

    @PostMapping("/createCalificacion")
    public ResponseEntity<String> createCalificacion(@RequestBody CreateCalificacionesDTO createCalificacionesDTO) {
        service.createCalificacion(createCalificacionesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Calificacion creada");
    }

    @PatchMapping("/editCalificaciones/{id}")
    public ResponseEntity<String> editCalificaciones(@PathVariable Long id, @RequestBody EditCalificacionDTO editCalificaciones) {
        service.editCalificaciones(id, editCalificaciones);
        return ResponseEntity.status(HttpStatus.CREATED).body("Calificacion editada");
    }
}
