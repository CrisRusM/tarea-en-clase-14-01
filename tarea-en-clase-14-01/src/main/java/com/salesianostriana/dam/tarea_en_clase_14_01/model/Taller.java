package com.salesianostriana.dam.tarea_en_clase_14_01.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Taller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ciudad;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Mantenimiento> mantenimientos;

}
