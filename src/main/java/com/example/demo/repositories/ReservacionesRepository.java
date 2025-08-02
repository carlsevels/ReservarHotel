package com.example.demo.repositories;

import com.example.demo.models.Reservaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservacionesRepository extends JpaRepository<Reservaciones, Long> {
}
