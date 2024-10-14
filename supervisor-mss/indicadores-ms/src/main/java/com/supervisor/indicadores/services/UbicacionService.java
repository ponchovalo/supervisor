package com.supervisor.indicadores.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.supervisor.indicadores.dtos.UbicacionCsvRepresentation;
import com.supervisor.indicadores.entity.Ubicacion;
import com.supervisor.indicadores.repository.IUbicacionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UbicacionService {

    @Autowired
    private IUbicacionRepository ubicacionRepository;

    public Integer uploadUbicaciones(MultipartFile file) throws IOException {
        Set<Ubicacion> ubicacion = parseCsv(file);
        ubicacionRepository.saveAll(ubicacion);
        return ubicacion.size();
    }

    private Set<Ubicacion> parseCsv(MultipartFile file) throws IOException {

        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream(),"UTF-8"))){
            HeaderColumnNameMappingStrategy<UbicacionCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();

            strategy.setType(UbicacionCsvRepresentation.class);

            CsvToBean<UbicacionCsvRepresentation> csVToBean =
                    new CsvToBeanBuilder<UbicacionCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            return csVToBean.parse()
                    .stream()
                    .map(csvLine -> Ubicacion.builder()
                            .area_conocida(csvLine.getArea_conocida())
                            .id_area(csvLine.getId_area())
                            .nombre_area(csvLine.getNombre_area())
                            .id_unidad(csvLine.getId_unidad())
                            .nombre_unidad(csvLine.getNombre_unidad())
                            .build()
                    ).collect(Collectors.toSet());

        }
    }

}
