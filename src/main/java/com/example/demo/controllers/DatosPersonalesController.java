package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.DatosPersonales;
import com.example.demo.repositories.DatosPersonalesRepository;

@RestController
@RequestMapping("/datosPersonales")
public class DatosPersonalesController {

    public final DatosPersonalesRepository datosPersonalesRepository;

    public DatosPersonalesController(DatosPersonalesRepository datosPersonalesRepository){
        this.datosPersonalesRepository = datosPersonalesRepository;
    }
    
    @GetMapping
    final List<DatosPersonales> getDatosPersonales(){
        return datosPersonalesRepository.findAll();
    }

   @PostMapping
   final DatosPersonales creatPersonales(@RequestBody DatosPersonales datosPersonales){
    return datosPersonalesRepository.save(datosPersonales);
   } 
}
