package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Hoteles;

public interface HotelesRepository extends JpaRepository<Hoteles, Long> {
    
}
