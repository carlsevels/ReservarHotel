package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Fechas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Agrega campos aquí

    public Fechas() {}
}
