package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Galeria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imagen;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "habitacionId")
    @JsonManagedReference
    private Habitaciones habitacion;

    // TODO: Agrega campos aquí

    public Galeria() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
