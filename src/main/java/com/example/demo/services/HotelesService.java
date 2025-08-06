package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.CamasDTO;
import com.example.demo.DTO.DescripcionesDTO;
import com.example.demo.DTO.GaleriaDTO;
import com.example.demo.DTO.HabitacionesDTO;
import com.example.demo.DTO.HotelesDTO;
import com.example.demo.DTO.IdiomasDTO;
import com.example.demo.DTO.ServiciosDTO;
import com.example.demo.models.Camas;
import com.example.demo.models.Descripciones;
import com.example.demo.models.Galeria;
import com.example.demo.models.Habitaciones;
import com.example.demo.models.Hoteles;
import com.example.demo.models.Idiomas;
import com.example.demo.models.Servicios;
import com.example.demo.models.TiposCamas;
import com.example.demo.repositories.HotelesRepository;
import com.example.demo.repositories.TiposCamasRepository;

@Service
public class HotelesService {
    private final HotelesRepository hotelesRepository;
    private final TiposCamasRepository tiposCamasRepository;

    public HotelesService(HotelesRepository hotelesRepository, TiposCamasRepository tiposCamasRepository) {
        this.hotelesRepository = hotelesRepository;
        this.tiposCamasRepository = tiposCamasRepository;
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

            Habitaciones habitaciones = new Habitaciones();
            List<Galeria> listGaleria = new ArrayList<>();
            List<Camas> listCamas = new ArrayList<>();

            habitaciones.setNombre(habitacionesList.getNombre());
            habitaciones.setCantidadPersonas(habitacionesList.getCantidadPersonas());
            habitaciones.setHotel(hoteles);
            listaHabitaciones.add(habitaciones);

            // Galeria
            for (GaleriaDTO galeriaListDTO : habitacionesList.getGaleriaDTO()) {
                Galeria galeria = new Galeria();
                galeria.setImagen(galeriaListDTO.getImagen());
                galeria.setHabitacion(habitaciones);
                listGaleria.add(galeria);
            }

            // Camas
            for (CamasDTO camasDTO : habitacionesList.getCamasDTO()) {
                Camas camas = new Camas();
                camas.setCantidad(camasDTO.getCantidad());
                camas.setHabitacion(habitaciones);

                // Tipos Camas - Este codigo permite agregar el "id" del tipo de cama existente
                // en la base de datos.
                TiposCamas tipoCama = tiposCamasRepository
                        .findById(camasDTO.getTipoCamaId())
                        .orElseThrow(() -> new RuntimeException("Tipo de cama no encontrado"));
                camas.setTipoCama(tipoCama);

                listCamas.add(camas);
            }
            habitaciones.setGaleria(listGaleria);
            habitaciones.setCamas(listCamas);
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
