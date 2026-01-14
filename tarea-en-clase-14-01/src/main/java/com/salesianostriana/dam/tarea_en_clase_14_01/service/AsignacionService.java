package com.salesianostriana.dam.tarea_en_clase_14_01.service;

import com.salesianostriana.dam.tarea_en_clase_14_01.dto.CreateAsignacionRequest;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Asignacion;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Conductor;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Estado;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Vehiculo;
import com.salesianostriana.dam.tarea_en_clase_14_01.repository.AsignacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AsignacionService {

    private AsignacionRepository asignacionRepository;
    private VehiculoService vehiculoService;
    private ConductorService conductorService;

    public Asignacion asignar(CreateAsignacionRequest createAsignacionRequest){
        List<Asignacion> asignacionesVehiculo = asignacionRepository.findAllByVehiculo_Id(createAsignacionRequest.vehiculo_id());
        List<Asignacion> asignacionesConductores = asignacionRepository.findAllByConductor_Id(createAsignacionRequest.conductor_id());

        Vehiculo vehiculo = vehiculoService.findById(createAsignacionRequest.vehiculo_id());
        Conductor conductor = conductorService.findById(createAsignacionRequest.conductor_id());


        if (!(asignacionesVehiculo.stream()
                .filter(av -> av.getFechaFin()==null)
                .toList())
                .isEmpty()){
            throw new RuntimeException("Este vehículo ya tiene una asignación activa.");
        }

        if (!(asignacionesConductores.stream()
                .filter(ac -> ac.getFechaFin()==null)
                .toList())
                .isEmpty()){
            throw new RuntimeException("Este conductor ya tiene una asignación activa.");
        }
        vehiculo.setEstado(Estado.ASIGNADO);
        vehiculoService.actualizar(vehiculo);
        return asignacionRepository.save(Asignacion.builder()
                .fechaInicio(LocalDate.now())
                .vehiculo(vehiculo)
                .conductor(conductor)
                .build());

    }

    public Asignacion findById(Long id){
        return asignacionRepository.findById(id).orElseThrow(()-> new RuntimeException("No se ha encontrado una asignación con este id."));
    }

    public Asignacion cerrar(Long asignacion_id){
        Asignacion asignacion = findById(asignacion_id);

        if (asignacion.getFechaFin()!=null){
            throw new RuntimeException("Esta asignación ya está completada.");
        }

        asignacion.setFechaFin(LocalDate.now());
        Vehiculo vehiculo= asignacion.getVehiculo();
        vehiculo.setEstado(Estado.DISPONIBLE);
        vehiculoService.actualizar(vehiculo);
        return asignacionRepository.save(asignacion);
    }



}
