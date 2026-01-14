package com.salesianostriana.dam.tarea_en_clase_14_01.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@NamedEntityGraph(
        name = "Asignacion.vehiculo",
        attributeNodes = @NamedAttributeNode("vehiculo")
)
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;

    @Nullable
    private LocalDate fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @JoinColumn(name = "conductor_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Conductor conductor;
}
