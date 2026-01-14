package com.salesianostriana.dam.tarea_en_clase_14_01.service;

import com.salesianostriana.dam.tarea_en_clase_14_01.dto.CreateMantenimientoRequest;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Estado;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Mantenimiento;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Vehiculo;
import com.salesianostriana.dam.tarea_en_clase_14_01.repository.MantenimientoRepository;
import org.springframework.stereotype.Service;

@Service
public class MantenimientoService {
    private MantenimientoRepository mantenimientoRepository;
    private VehiculoService vehiculoService;

    public Mantenimiento registrar(CreateMantenimientoRequest createMantenimientoRequest){

        Vehiculo vehiculo= vehiculoService.findById(createMantenimientoRequest.vehiculo_id());

        if(vehiculo.getEstado().equals(Estado.ASIGNADO)){
            throw new RuntimeException("No se puede hacer mantenimiento a un vehículo asignado.");
        }

        if(createMantenimientoRequest.kmEnRevision()<vehiculo.getKmActuales()){
            throw new RuntimeException("El kilometraje del mantenimiento debe ser mayor o igual al km actual del vehículo.");
        }

        vehiculoService.actualizarEnMantenimiento(vehiculo, createMantenimientoRequest.kmEnRevision());

        return mantenimientoRepository.save(Mantenimiento.builder()
                .tipo(createMantenimientoRequest.tipo())
                .fecha(createMantenimientoRequest.fecha())
                .kmEnRevision(createMantenimientoRequest.kmEnRevision())
                .vehiculo(vehiculo)
                .build());

    }

}
