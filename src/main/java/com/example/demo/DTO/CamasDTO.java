package com.example.demo.DTO;

public class CamasDTO {
    private Integer cantidad;
    private Long tipoCamaId;

    public CamasDTO(Integer cantidad, Long tipoCamaId) {
        this.cantidad = cantidad;
        this.tipoCamaId = tipoCamaId;
    }

    // Getters & Setters
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getTipoCamaId() {
        return tipoCamaId;
    }

    public void getTipoCamaId(Long tipoCamaId) {
        this.tipoCamaId = tipoCamaId;
    }
}
