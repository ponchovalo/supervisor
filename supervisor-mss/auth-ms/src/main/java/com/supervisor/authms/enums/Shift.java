package com.supervisor.authms.enums;

import lombok.Getter;

@Getter
public enum Shift {

    GUARDIA_TA("Guardia TA", "08:00 - 20:00"),
    NOCTURNO("Nocturno", "20:00 - 08:00"),
    ADMINISTRATIVO("Administrativo", "08:00 - 17:00");

    private final String name;
    private final String whours;

    Shift(String name, String whours) {
        this.name = name;
        this.whours = whours;
    }
}
