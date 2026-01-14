package com.salesianostriana.dam.tarea_en_clase_14_01.service;

import com.salesianostriana.dam.tarea_en_clase_14_01.model.Estado;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Vehiculo;
import com.salesianostriana.dam.tarea_en_clase_14_01.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehiculoService {
    private VehiculoRepository vehiculoRepository;

    public Vehiculo findById(Long id){
        return vehiculoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se ha encontrado un vehículo con ese id."));
    }

    public Vehiculo actualizarEnMantenimiento(Vehiculo vehiculo, int kilometros){
        vehiculo.setKmActuales(kilometros);
        vehiculo.setEstado(Estado.EN_MANTENIMIENTO);
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo actualizar(Vehiculo vehiculo){
        if(vehiculoRepository.existsByMatriculaIgnoreCase(vehiculo.getMatricula())){
            if (!vehiculoRepository.existsByMatriculaIgnoreCaseAndId(vehiculo.getMatricula(), vehiculo.getId())){
                throw new RuntimeException("Ya existe un vehículo con esa matrícula");
            }
        }
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo crear(Vehiculo vehiculo){
        if(vehiculoRepository.existsByMatriculaIgnoreCase(vehiculo.getMatricula())){
            throw new RuntimeException("Ya existe un vehículo con esa matrícula");
        }
        return vehiculoRepository.save(vehiculo);
    }



























}
