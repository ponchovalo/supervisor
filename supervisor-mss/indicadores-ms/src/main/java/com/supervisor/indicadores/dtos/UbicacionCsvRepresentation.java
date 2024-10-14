package com.supervisor.indicadores.dtos;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UbicacionCsvRepresentation {

    @CsvBindByName(column = "area_conocida")
    private String area_conocida;

    @CsvBindByName(column = "id_area")
    private String id_area;

    @CsvBindByName(column = "nombre_area")
    private String nombre_area;

    @CsvBindByName(column = "id_unidad")
    private String id_unidad;

    @CsvBindByName(column = "nombre_unidad")
    private String nombre_unidad;

}
