package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Reservaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Users user;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Fechas fecha;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Habitaciones habitacion;

    // TODO: Agrega campos aquí

    public Reservaciones() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
