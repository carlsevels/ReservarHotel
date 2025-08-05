package com.example.demo.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelesDTO {
    private String nombre;
    private String descripcion;

    @JsonProperty("habitacionesDTO")
    private List<HabitacionesDTO> habitaciones;

    @JsonProperty("idiomasDTO")
    private List<IdiomasDTO> idiomas;

    @JsonProperty("serviciosDTO")
    private List<ServiciosDTO> servicios;

    public HotelesDTO(String nombre, String descripcion, List<HabitacionesDTO> habitaciones, List<IdiomasDTO> idiomas,
            List<ServiciosDTO> servicios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.habitaciones = habitaciones;
        this.idiomas = idiomas;
        this.servicios = servicios;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<HabitacionesDTO> getHabitacionesDTO() {
        return habitaciones;
    }

    public void setHabitaciones(List<HabitacionesDTO> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<IdiomasDTO> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<IdiomasDTO> idiomas) {
        this.idiomas = idiomas;
    }

    public List<ServiciosDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServiciosDTO> servicios) {
        this.servicios = servicios;
    }
}
