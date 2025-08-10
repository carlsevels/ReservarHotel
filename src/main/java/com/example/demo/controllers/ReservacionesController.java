package com.example.demo.controllers;

import com.example.demo.DTO.CreateReservationDTO;
import com.example.demo.models.Reservaciones;
import com.example.demo.services.ReservacionesService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservaciones")
public class ReservacionesController {
    private final ReservacionesService service;

    public ReservacionesController(ReservacionesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservaciones> getAll() {
        return service.getAll();
    }
    
    // Create Reservation
    @PostMapping("/createReservation")
    public ResponseEntity<String> crearUsuario(@RequestBody CreateReservationDTO dto) {
        service.createReservationDTO(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reservacion creado correctamente");
    }
}
