package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class TiposCamas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tipoCama")
    @JoinColumn(name = "tipoCamaId")
    @JsonManagedReference
    private Camas cama;

    // TODO: Agrega campos aquí

    public TiposCamas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
