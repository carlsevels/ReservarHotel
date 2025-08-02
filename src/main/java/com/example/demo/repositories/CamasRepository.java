package com.example.demo.repositories;

import com.example.demo.models.Camas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamasRepository extends JpaRepository<Camas, Long> {
}
