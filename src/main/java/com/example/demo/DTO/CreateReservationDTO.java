package com.example.demo.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateReservationDTO {
    private Long habitacionId;
    private Long userId;
    private List<UsersDTO> usersDTO;

    @JsonProperty("fechaDTO")
    private FechasDTO fechaDTO;

    CreateReservationDTO() {
    }

    // Getters & Setters
    public Long getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Long habitacionId) {
        this.habitacionId = habitacionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<UsersDTO> getUsersDTO() {
        return usersDTO;
    }

    public void setUsersDTO(List<UsersDTO> usersDTO) {
        this.usersDTO = usersDTO;
    }

    public FechasDTO getFechaDTO() {
        return fechaDTO;
    }

    public void setFechaDTO(FechasDTO fechaDTO) {
        this.fechaDTO = fechaDTO;
    }
}
