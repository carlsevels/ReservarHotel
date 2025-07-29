package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.DatosPersonales;

public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, Long> {
    
}
