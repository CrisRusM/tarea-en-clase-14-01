package com.salesianostriana.dam.tarea_en_clase_14_01.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Vehiculo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricula;
    private String modelo;
    private int kmActuales;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Asignacion> asignaciones;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Mantenimiento> mantenimientos;












}
