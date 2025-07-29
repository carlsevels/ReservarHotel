package com.example.demo.services;

import java.util.List;

import com.example.demo.models.DatosPersonales;
import com.example.demo.repositories.DatosPersonalesRepository;

public class DatosPersonalesService {
    public final DatosPersonalesRepository datosPersonalesRepository;

    public DatosPersonalesService(DatosPersonalesRepository datosPersonalesRepository){
        this.datosPersonalesRepository = datosPersonalesRepository;
    }

    public List<DatosPersonales> getAllDatosPersonales(){
        return datosPersonalesRepository.findAll();
    }
}
