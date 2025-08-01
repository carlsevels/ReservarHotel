package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Hoteles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String descripcion;
    private Integer capacidad;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Idiomas> idiomas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    @JsonManagedReference
    private List<Servicios> servicios;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    @JsonManagedReference
    private List<Habitaciones> habitaciones;

    public Hoteles() {}

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Integer getCapacidad(){
        return capacidad;
    }

    public void setCapacidad(Integer capacidad){
        this.capacidad = capacidad;
    }

    public List<Idiomas> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idiomas> idiomas){
        this.idiomas = idiomas;
    }
}
