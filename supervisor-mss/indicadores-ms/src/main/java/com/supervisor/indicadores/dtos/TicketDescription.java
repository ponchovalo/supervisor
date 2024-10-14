package com.supervisor.indicadores.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDescription {
    private String device;
    private String ticket_description;
}
