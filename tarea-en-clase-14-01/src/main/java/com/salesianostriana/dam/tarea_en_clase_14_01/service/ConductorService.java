package com.salesianostriana.dam.tarea_en_clase_14_01.service;

import com.salesianostriana.dam.tarea_en_clase_14_01.model.Conductor;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Vehiculo;
import com.salesianostriana.dam.tarea_en_clase_14_01.repository.ConductorRepository;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {

    private ConductorRepository conductorRepository;

    public Conductor findById(Long id){
        return conductorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se ha encontrado un conductor con ese id."));
    }

}
