package com.supervisor.indicadores.services;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.supervisor.indicadores.dtos.PlantillaCsvRepresentation;
import com.supervisor.indicadores.entity.Plantilla;
import com.supervisor.indicadores.repository.IPlantillaRepository;
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
public class PlantillaServices {

    @Autowired
    private IPlantillaRepository plantillaRepository;


    public Integer uploadPlantillas(MultipartFile file) throws IOException {
        Set<Plantilla> plantillas = parseCsv(file);
        plantillaRepository.saveAll(plantillas);
        return plantillas.size();
    }

    private Set<Plantilla> parseCsv(MultipartFile file) throws IOException {

        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream(),"UTF-8"))) {
            HeaderColumnNameMappingStrategy<PlantillaCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();

            strategy.setType(PlantillaCsvRepresentation.class);

            CsvToBean<PlantillaCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<PlantillaCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();

            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> Plantilla.builder()
                            .activity_pt_st(csvLine.getActivity_pt_st())
                            .activity_type(csvLine.getActivity_type())
                            .ticket_description(csvLine.getTicket_description())
                            .admin_activity(csvLine.getAdmin_activity())
                            .fault_type(csvLine.getFault_type())
                            .fault_cat(csvLine.getFault_cat())
                            .tech_description(csvLine.getTech_description())
                            .fault_case(csvLine.getFault_case())
                            .device(csvLine.getDevice())
                            .solution_type(csvLine.getSolution_type())
                            .tools(csvLine.getTools())
                            .suplies(csvLine.getSuplies())
                            .party_number(csvLine.getParty_number())
                            .party_desc(csvLine.getParty_desc())
                            .comments(csvLine.getComments())
                            .build()
                    )
                    .collect(Collectors.toSet());

        }
    }
}
