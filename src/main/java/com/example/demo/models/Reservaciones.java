package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Reservaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Users user;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Fechas fecha;
    
    @ManyToOne
    @JoinColumn(name = "habitacion_id") // FK en la tabla reservaciones
    @JsonBackReference
    private Habitaciones habitacion;
    
    
    // TODO: Agrega campos aquí

    public Reservaciones() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Habitaciones getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitaciones habitacion) {
        this.habitacion = habitacion;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Fechas getFecha() {
        return fecha;
    }

    public void setFecha(Fechas fecha) {
        this.fecha = fecha;
    }
}
