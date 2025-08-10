package com.example.demo.DTO;

import java.sql.Date;

public class FechasDTO {
    private Date fechaInicio;
    private Date fechaFin;

    public FechasDTO(Date fechaInicio, Date fechaFin) {
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
    }

    // Getters and Setters
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
