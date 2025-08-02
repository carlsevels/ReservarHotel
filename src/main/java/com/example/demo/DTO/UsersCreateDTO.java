package com.example.demo.DTO;

public class UsersCreateDTO {
    private String email;
    private String password;
    private DatosPersonalesDTO datosPersonalesDTO;

    UsersCreateDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DatosPersonalesDTO getDatosPersonalesDTO() {
        return datosPersonalesDTO;
    }

    public void setDatosPersonalesDTO(DatosPersonalesDTO datosPersonalesDTO) {
        this.datosPersonalesDTO = datosPersonalesDTO;
    }
}
