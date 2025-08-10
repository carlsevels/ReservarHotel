package com.example.demo.services;

import com.example.demo.DTO.CreateReservationDTO;
import com.example.demo.models.Fechas;
import com.example.demo.models.Habitaciones;
import com.example.demo.models.Reservaciones;
import com.example.demo.models.TiposCamas;
import com.example.demo.models.Users;
import com.example.demo.repositories.HabitacionesRepository;
import com.example.demo.repositories.ReservacionesRepository;
import com.example.demo.repositories.UsersRepository;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ReservacionesService {
    private final ReservacionesRepository repository;
    private final HabitacionesRepository habitacionesRepository;
    private final UsersRepository usersRepository;

    public ReservacionesService(ReservacionesRepository repository, HabitacionesRepository habitacionesRepository,
            UsersRepository usersRepository) {
        this.repository = repository;
        this.habitacionesRepository = habitacionesRepository;
        this.usersRepository = usersRepository;
    }

    public List<Reservaciones> getAll() {
        return repository.findAll();
    }
    
    public Reservaciones createReservationDTO(CreateReservationDTO reservationDTO) {
        Reservaciones reservaciones = new Reservaciones();
        Fechas fechas = new Fechas();
    
        // Usuario existente
        Users users = usersRepository.findById(reservationDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        reservaciones.setUser(users);
    
        // Habitación existente
        Habitaciones habitacion = habitacionesRepository
                .findById(reservationDTO.getHabitacionId())
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada"));
        reservaciones.setHabitacion(habitacion);
    
        // Fechas
        fechas.setFechaInicio(reservationDTO.getFechaDTO().getFechaInicio());
        fechas.setFechaFin(reservationDTO.getFechaDTO().getFechaFin());
        fechas.setReservacion(reservaciones);
        reservaciones.setFecha(fechas);
    
        return repository.save(reservaciones);
    }
    

}
