package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Hoteles;
import com.example.demo.repositories.HotelesRepository;

public class HotelesService {
    private final HotelesRepository hotelesRepository;

    public HotelesService(HotelesRepository hotelesRepository){
        this.hotelesRepository = hotelesRepository;
    }

    public List<Hoteles>  getAllHoteles(){
        return hotelesRepository.findAll();
    }
}
