package com.example.demo.models;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public Hoteles getHotel() {
        return hotel;
    }

    public void setHotel(Hoteles hotel) {
        this.hotel = hotel;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
