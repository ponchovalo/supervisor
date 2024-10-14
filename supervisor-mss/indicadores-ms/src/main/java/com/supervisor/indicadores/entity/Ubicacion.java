package com.supervisor.indicadores.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(columnDefinition = "text")
    private String area_conocida;

    @Column(columnDefinition = "text")
    private String id_area;

    @Column(columnDefinition = "text")
    private String nombre_area;

    @Column(columnDefinition = "text")
    private String id_unidad;

    @Column(columnDefinition = "text")
    private String nombre_unidad;
}
