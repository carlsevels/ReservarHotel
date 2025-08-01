package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Descripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    // TODO: Agrega campos aquí

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicioId")
    @JsonManagedReference
    private Servicios servicios;

    public Descripciones() {}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
