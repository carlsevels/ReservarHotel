package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.HotelesDTO;
import com.example.demo.models.Hoteles;
import com.example.demo.services.HotelesService;

@RestController
@RequestMapping("/hoteles")
public class HotelesController {
   private final HotelesService hotelesService;

   public HotelesController(HotelesService hotelesService) {
      this.hotelesService = hotelesService;
   }

   @GetMapping
   public List<Hoteles> getAll() {
      return hotelesService.getAllHoteles();
   }

   @PostMapping
   public ResponseEntity<String> createHotel(@RequestBody HotelesDTO hotelesDTO) {
      hotelesService.createHotel(hotelesDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body("Hotel creado correctamente!");
   }

}
