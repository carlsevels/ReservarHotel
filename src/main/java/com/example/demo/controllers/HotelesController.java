package com.example.demo.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Hoteles;
import com.example.demo.services.HotelesService;

@RequestMapping("/hoteles")
public class HotelesController {
   private final HotelesService hotelesService;

   public HotelesController(HotelesService hotelesService){
    this.hotelesService = hotelesService;
   }
   
   @GetMapping
   public List<Hoteles> getAll(){
    return hotelesService.getAllHoteles();
   }

}
