package com.supervisor.indicadores.dtos;


import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlantillaCsvRepresentation {

    @CsvBindByName(column = "activity_pt_st")
    public String activity_pt_st;

    @CsvBindByName(column = "activity_type")
    private String activity_type;

    @CsvBindByName(column = "ticket_description")
    private String ticket_description;

    @CsvBindByName(column = "admin_activity")
    private String admin_activity;

    @CsvBindByName(column = "fault_type")
    private String fault_type;

    @CsvBindByName(column = "fault_cat")
    private String fault_cat;

    @CsvBindByName(column = "tech_description")
    private String tech_description;

    @CsvBindByName(column = "fault_case")
    private String fault_case;

    @CsvBindByName(column = "device")
    private String device;

    @CsvBindByName(column = "solution_type")
    private String solution_type;

    @CsvBindByName(column = "tools")
    private String tools;

    @CsvBindByName(column = "suplies")
    private String suplies;

    @CsvBindByName(column = "party_number")
    private String party_number;

    @CsvBindByName(column = "party_desc")
    private String party_desc;

    @CsvBindByName(column = "comments")
    private String comments;
}
