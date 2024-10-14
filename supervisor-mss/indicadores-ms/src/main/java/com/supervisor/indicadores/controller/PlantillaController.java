package com.supervisor.indicadores.controller;

import com.supervisor.indicadores.dtos.DeviceTyActivity;
import com.supervisor.indicadores.dtos.Party;
import com.supervisor.indicadores.dtos.TicketDescription;
import com.supervisor.indicadores.entity.Plantilla;
import com.supervisor.indicadores.repository.IPlantillaRepository;

import com.supervisor.indicadores.services.PlantillaServices;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.beans.Encoder;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/plantillas")
@RequiredArgsConstructor
public class PlantillaController {

    @Autowired
    private PlantillaServices plantillaServices;

    @Autowired
    private IPlantillaRepository plantillaRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Plantilla> getAllPlantillas(){
        return plantillaRepository.findAll();
    }

    @GetMapping("/partidas")
    @ResponseStatus(HttpStatus.OK)
    public List<Party> getAllParties() {
        return plantillaRepository.findDistinctParties();
    }

    @PostMapping("/devices")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getDevicesForParty(@RequestBody Party party ) {
        return plantillaRepository.findDistinctDevices(party.getParty_number());
    }

    @GetMapping("/activity_types")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getActivityTypes() {
        return plantillaRepository.findDistinctActivityTypes();
    }

    @PostMapping("/ticket_description")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getTicketDescription(@RequestBody DeviceTyActivity deviceTyActivity){
        return plantillaRepository.findDistinctTiketDescription(deviceTyActivity.getDevice(), deviceTyActivity.getActivity_type());
    }

    @PostMapping("/tech_description")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getTechDescription(@RequestBody TicketDescription ticketDescription){
        return plantillaRepository.findByTicketDescription(ticketDescription.getDevice(), ticketDescription.getTicket_description() );
    }

    /* ---- INSERTAR UNA PLANTILLA ---- */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createPlantilla(@Valid @RequestBody Plantilla plantilla){
        plantillaRepository.save(plantilla);
    }

    /* ---- INSERTAR VARIAS PLANTILLAS ---- */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Integer> uploadPlantillas(
            @RequestPart("file") MultipartFile file) throws IOException {
                return ResponseEntity.ok(plantillaServices.uploadPlantillas(file));
    }







}
