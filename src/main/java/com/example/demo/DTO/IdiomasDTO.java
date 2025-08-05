package com.example.demo.DTO;

public class IdiomasDTO {
    private String nombre;

    public IdiomasDTO(String nombre) {
        this.nombre = nombre;
    }

    //Getters & Setters
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
