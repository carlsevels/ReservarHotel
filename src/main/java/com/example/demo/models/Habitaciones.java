package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Habitaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer cantidadPersonas;

    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Servicios> servicios;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelId")
    private Hoteles hotel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "habitacion")
    @JsonManagedReference
    private List<Galeria> galeria;

    // TODO: Agrega campos aquí

    public Habitaciones() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public List<Servicios> getServicios(){
        return servicios;
    }

    public void setServicios(List<Servicios> servicios){
        this.servicios = servicios;
    }
}
