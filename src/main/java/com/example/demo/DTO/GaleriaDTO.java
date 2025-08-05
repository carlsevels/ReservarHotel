package com.example.demo.DTO;

public class GaleriaDTO {
    private String imagen;

    public GaleriaDTO(String imagen){
        this.imagen = imagen;
    }

    // Getters and Settings
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
