package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.DescripcionesDTO;
import com.example.demo.DTO.GaleriaDTO;
import com.example.demo.DTO.HabitacionesDTO;
import com.example.demo.DTO.HotelesDTO;
import com.example.demo.DTO.IdiomasDTO;
import com.example.demo.DTO.ServiciosDTO;
import com.example.demo.models.Descripciones;
import com.example.demo.models.Galeria;
import com.example.demo.models.Habitaciones;
import com.example.demo.models.Hoteles;
import com.example.demo.models.Idiomas;
import com.example.demo.models.Servicios;
import com.example.demo.repositories.HotelesRepository;

@Service
public class HotelesService {
    private final HotelesRepository hotelesRepository;

    public HotelesService(HotelesRepository hotelesRepository) {
        this.hotelesRepository = hotelesRepository;
    }

    public List<Hoteles> getAllHoteles() {
        return hotelesRepository.findAll();
    }

    public Hoteles createHotel(HotelesDTO hotelesDTO) {
        Hoteles hoteles = new Hoteles();
        hoteles.setNombre(hotelesDTO.getNombre());
        hoteles.setDescripcion(hotelesDTO.getDescripcion());

        List<Habitaciones> listaHabitaciones = new ArrayList<>();
        List<Idiomas> listIdiomas = new ArrayList<>();
        List<Servicios> listServicios = new ArrayList<>();

        for (HabitacionesDTO habitacionesList : hotelesDTO.getHabitacionesDTO()) {
            // Galeria
            Habitaciones habitaciones = new Habitaciones();
            List<Galeria> listGaleria = new ArrayList<>();

            habitaciones.setNombre(habitacionesList.getNombre());
            habitaciones.setCantidadPersonas(habitacionesList.getCantidadPersonas());
            habitaciones.setHotel(hoteles);
            listaHabitaciones.add(habitaciones);
            for (GaleriaDTO galeriaListDTO : habitacionesList.getGaleriaDTO()) {
                Galeria galeria = new Galeria();
                galeria.setImagen(galeriaListDTO.getImagen());
                galeria.setHabitacion(habitaciones);
                listGaleria.add(galeria);
            }
            habitaciones.setGaleria(listGaleria);
        }

        for (IdiomasDTO idiomasDTO : hotelesDTO.getIdiomas()) {
            Idiomas idiomas = new Idiomas();
            idiomas.setNombre(idiomasDTO.getNombre());
            idiomas.setHotel(hoteles);
            listIdiomas.add(idiomas);
        }

        for (ServiciosDTO serviciosDTO : hotelesDTO.getServicios()) {
            Servicios servicios = new Servicios();
            servicios.setNombre(serviciosDTO.getNombre());
            servicios.setHotel(hoteles);
            listServicios.add(servicios);

            // Descripciones del servicio
            List<Descripciones> descripcionesList = new ArrayList<>();

            for (DescripcionesDTO descripcionesListDTO : serviciosDTO.getDescripcionesDTO()) {
                Descripciones descripcion = new Descripciones();
                descripcion.setDescripcion(descripcionesListDTO.getDescripcion());
                descripcion.setServicio(servicios);
                descripcionesList.add(descripcion);
            }
            servicios.setDescripciones(descripcionesList);
        }

        hoteles.setHabitaciones(listaHabitaciones);
        hoteles.setIdiomas(listIdiomas);
        hoteles.setServicios(listServicios);

        return hotelesRepository.save(hoteles);
    }
}
