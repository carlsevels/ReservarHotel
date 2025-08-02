package com.example.demo.DTO;

public class UsersDTO {
    private String email;
    private DatosPersonalesDTO datosPersonalesDTO;

    public UsersDTO(String email, DatosPersonalesDTO datosPersonalesDTO) {
        this.email = email;
        this.datosPersonalesDTO = datosPersonalesDTO;
    }

    // getters y setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DatosPersonalesDTO getDatosPeronalesDTO() {
        return datosPersonalesDTO;
    }

    public void setDatosPeronalesDTO(DatosPersonalesDTO datosPersonalesDTO) {
        this.datosPersonalesDTO = datosPersonalesDTO;
    }
}
