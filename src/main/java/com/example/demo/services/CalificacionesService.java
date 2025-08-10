package com.example.demo.services;

import com.example.demo.DTO.CreateCalificacionesDTO;
import com.example.demo.DTO.EditCalificacionDTO;
import com.example.demo.models.Calificaciones;
import com.example.demo.models.Hoteles;
import com.example.demo.models.Users;
import com.example.demo.repositories.CalificacionesRepository;
import com.example.demo.repositories.HotelesRepository;
import com.example.demo.repositories.UsersRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CalificacionesService {
    private final CalificacionesRepository repository;
    private final HotelesRepository hotelesRepository;
    private UsersRepository usersRepository;

    public CalificacionesService(CalificacionesRepository repository, HotelesRepository hotelesRepository,
            UsersRepository usersRepository) {
        this.repository = repository;
        this.hotelesRepository = hotelesRepository;
        this.usersRepository = usersRepository;
    }

    public List<Calificaciones> getAll() {
        return repository.findAll();
    }

    public Calificaciones createCalificacion(CreateCalificacionesDTO createCalificacionesDTO) {
        Calificaciones calificaciones = new Calificaciones();

        calificaciones.setCalificacion(createCalificacionesDTO.getCalificacion());

        // Obtener el "id" de hotel existente en la base de datos
        Hoteles hoteles = hotelesRepository.findById(createCalificacionesDTO.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel no encontrado."));
        calificaciones.setHotel(hoteles);

        Users users = usersRepository.findById(createCalificacionesDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("Error al encontrar el usuario."));
        calificaciones.setUser(users);

        return repository.save(calificaciones);
    }

    public Calificaciones editCalificaciones(@PathVariable Long id, EditCalificacionDTO editCalificacionesDTO) {

        Calificaciones calificacionExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("La calificación con ID " + id + " no existe"));
        calificacionExistente.setCalificacion(editCalificacionesDTO.getCalificacion());

        return repository.save(calificacionExistente);
    }
}
