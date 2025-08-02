package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Calificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double calificacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Hoteles hotel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private Users user;

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
