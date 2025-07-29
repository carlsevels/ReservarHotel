package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Servicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Agrega campos aquí

    public Servicios() {}
}
