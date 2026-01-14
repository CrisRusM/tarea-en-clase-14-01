package com.salesianostriana.dam.tarea_en_clase_14_01.dto;

import java.time.LocalDate;

public record CreateMantenimientoRequest(String tipo, LocalDate fecha, int kmEnRevision, Long vehiculo_id) {
}
