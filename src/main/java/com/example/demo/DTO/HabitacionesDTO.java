package com.example.demo.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HabitacionesDTO {
    public String nombre;
    public Integer cantidadPersonas;
    public Long hotelId;

    @JsonProperty("galeriaDTO")
    public List<GaleriaDTO> galeriaDTO;

    @JsonProperty("camasDTO")
    public List<CamasDTO> camasDTO;

    public HabitacionesDTO(String nombre, Integer cantidadPersonas, Long hotelId, List<GaleriaDTO> galeriaDTO,
            List<CamasDTO> camasDTO) {
        this.nombre = nombre;
        this.cantidadPersonas = cantidadPersonas;
        this.hotelId = hotelId;
        this.galeriaDTO = galeriaDTO;
        this.camasDTO = camasDTO;
    }

    // Getters and Setters
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

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public List<GaleriaDTO> getGaleriaDTO() {
        return galeriaDTO;
    }

    public void setGaleriaDTO(List<GaleriaDTO> galeriaDTO) {
        this.galeriaDTO = galeriaDTO;
    }

    public List<CamasDTO> getCamasDTO() {
        return camasDTO;
    }

    public void setCamasDRO(List<CamasDTO> camasDTO) {
        this.camasDTO = camasDTO;
    }
}
