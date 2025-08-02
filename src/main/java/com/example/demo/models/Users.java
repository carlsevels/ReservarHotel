package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private DatosPersonales datosPersonales;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "calificacionesUsers", // nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "usuario_id"), // columna que representa a Users
            inverseJoinColumns = @JoinColumn(name = "calificacionId") // columna que representa a Hoteles
    )
    @JsonManagedReference
    private List<Calificaciones> calificaciones;

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailString) {
        emailString = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordString) {
        passwordString = password;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
        if (datosPersonales != null) {
            datosPersonales.setUsers(this);
        }
    }
}
