package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Camas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Habitaciones habitacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private TiposCamas tipoCama;

    // TODO: Agrega campos aquí

    public Camas() {}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Integer cantidad(){
        return cantidad;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }
}
