package com.example.demo.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCalificacionesDTO {
    private Double calificacion;
    private HotelesDTO hotel;
    private Long hotelId;
    private Long userId;

    @JsonProperty("userDTO")
    private List<UsersDTO> usersDTO;

    // Getters & Setters

    public Double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Double calificacion) {
        this.calificacion = calificacion;
    }

    public HotelesDTO getHotel() {
        return hotel;
    }

    public void setHotel(HotelesDTO hotel) {
        this.hotel = hotel;
    }

    public List<UsersDTO> getUsersDTO() {
        return usersDTO;
    }

    public void setUsersDTO(List<UsersDTO> usersDTO) {
        this.usersDTO = usersDTO;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
