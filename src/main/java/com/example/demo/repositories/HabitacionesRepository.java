package com.example.demo.repositories;

import com.example.demo.models.Habitaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionesRepository extends JpaRepository<Habitaciones, Long> {
}
