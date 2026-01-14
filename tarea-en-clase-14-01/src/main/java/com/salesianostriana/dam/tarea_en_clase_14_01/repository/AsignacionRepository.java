package com.salesianostriana.dam.tarea_en_clase_14_01.repository;

import com.salesianostriana.dam.tarea_en_clase_14_01.model.Asignacion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {

    @EntityGraph(value = "Asignacion.vehiculo", type = EntityGraph.EntityGraphType.LOAD)
    List<Asignacion>findAllByVehiculo_Id(Long id);

    @EntityGraph(value = "Asignacion.conductor", type = EntityGraph.EntityGraphType.LOAD)
    List<Asignacion>findAllByConductor_Id(Long id);
}
