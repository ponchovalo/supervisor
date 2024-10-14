package com.supervisor.indicadores.entity;

import com.supervisor.indicadores.dtos.PlantillaCsvRepresentation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.Type;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plantilla {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(columnDefinition = "text")
    @NotBlank(message = "activity_pt_st is required")
    private String activity_pt_st;

    @Column(columnDefinition = "text")
    @NotBlank(message = "activity_type is required")
    private String activity_type;

    @Column(columnDefinition = "text")
    @NotBlank(message = "ticket_description is required")
    private String ticket_description;

    @Column(columnDefinition = "text")
    private String admin_activity;

    @Column(columnDefinition = "text")
    private String fault_type;

    @Column(columnDefinition = "text")
    private String fault_cat;

    @Column(columnDefinition = "text", unique = true)
    @NotBlank(message = "tech_description is required")
    private String tech_description;

    @Column(columnDefinition = "text")
    private String fault_case;

    @Column(columnDefinition = "text")
    private String device;

    @Column(columnDefinition = "text")
    private String solution_type;

    @Column(columnDefinition = "text")
    private String tools;

    @Column(columnDefinition = "text")
    private String suplies;

    @Column(columnDefinition = "text")
    private String party_number;

    @Column(columnDefinition = "text")
    private String party_desc;

    @Column(columnDefinition = "text")
    private String comments;

}
