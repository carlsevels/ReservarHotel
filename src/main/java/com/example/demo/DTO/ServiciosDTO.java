package com.example.demo.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiciosDTO {
    private String nombre;

     @JsonProperty("descripcionDTO")
    private List<DescripcionesDTO> descripcionesDTO;

    public ServiciosDTO(String nombre, List<DescripcionesDTO> descripcionesDTO) {
        this.nombre = nombre;
        this.descripcionesDTO = descripcionesDTO;
    }

    // Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DescripcionesDTO> getDescripcionesDTO() {
        return descripcionesDTO;
    }

    public void setDescripcionesDTO(List<DescripcionesDTO> descripcionesDTO) {
        this.descripcionesDTO = descripcionesDTO;
    }
}
