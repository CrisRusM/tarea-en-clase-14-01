package com.salesianostriana.dam.tarea_en_clase_14_01.repository;

import com.salesianostriana.dam.tarea_en_clase_14_01.model.Vehiculo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @EntityGraph(value = "Asignacion.vehiculo", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Vehiculo> findByMatricula(String matricula);

    @Query("select (count(v) > 0) from Vehiculo v where upper(v.matricula) = upper(?1)")
    boolean existsByMatriculaIgnoreCase(String matricula);

    @Query("select (count(v) > 0) from Vehiculo v where upper(v.matricula) = upper(?1) and v.id = ?2")
    boolean existsByMatriculaIgnoreCaseAndId(String matricula, Long id);


}
