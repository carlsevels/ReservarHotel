package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JoinColumn(name = "hotel_id")
    @JsonManagedReference
    private Hoteles hotel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicios")
    @JsonManagedReference
    @JsonProperty("descripcionDTO")
    private List<Descripciones> descripcion;

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

    public Hoteles getHotel() {
        return hotel;
    }

    public void setHotel(Hoteles hotel) {
        this.hotel = hotel;
    }

    public List<Descripciones> getDescripciones() {
        return descripcion;
    }

    public void setDescripciones(List<Descripciones> descripcion) {
        this.descripcion = descripcion;
    }
}
