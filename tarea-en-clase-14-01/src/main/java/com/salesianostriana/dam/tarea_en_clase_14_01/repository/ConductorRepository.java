package com.salesianostriana.dam.tarea_en_clase_14_01.repository;

import com.salesianostriana.dam.tarea_en_clase_14_01.model.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
}
