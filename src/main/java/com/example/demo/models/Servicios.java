package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String nombre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habitacionId")
    @JsonManagedReference
    private Habitaciones habitacion;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelId")
    @JsonManagedReference
    private Hoteles hotel;

    // TODO: Agrega campos aquí

    public Servicios() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Habitaciones getHabitaciones() {
        return habitacion;
    }

    public void setHabitaciones(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }
}
