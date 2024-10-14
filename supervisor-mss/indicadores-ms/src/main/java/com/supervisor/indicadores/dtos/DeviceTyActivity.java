package com.supervisor.indicadores.dtos;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceTyActivity {
    private String device;
    private String activity_type;
}
