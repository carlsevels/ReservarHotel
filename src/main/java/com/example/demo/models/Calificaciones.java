package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Calificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double calificacion;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "calificaciones")
    @JsonBackReference
    private List<Users> users;

    // TODO: Agrega campos aquí

    public Calificaciones() {
    }

    public Long getId() {
        return id;
    }

    public void getId(Long id) {
        this.id = id;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void getCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

}
