package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class DatosPersonales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonBackReference
    private Users users;

    public DatosPersonales() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idLong) {
        this.id = idLong;
    }

    public String getNombreString() {
        return nombre;
    }

    public void setNombre(String nombreString) {
        this.nombre = nombreString;
    }

    public String getApellidoPaternoString() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaternoString) {
        this.apellidoPaterno = apellidoPaternoString;
    }

    public String getApellidoMaternoString() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaternoString) {
        this.apellidoMaterno = apellidoMaternoString;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
