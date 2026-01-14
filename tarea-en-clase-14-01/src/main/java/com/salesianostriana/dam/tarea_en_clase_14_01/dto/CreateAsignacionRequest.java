package com.salesianostriana.dam.tarea_en_clase_14_01.dto;

import com.salesianostriana.dam.tarea_en_clase_14_01.model.Conductor;
import com.salesianostriana.dam.tarea_en_clase_14_01.model.Vehiculo;

public record CreateAsignacionRequest(Long vehiculo_id, Long conductor_id) {
}
