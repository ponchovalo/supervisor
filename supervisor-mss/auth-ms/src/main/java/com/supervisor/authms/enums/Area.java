package com.supervisor.authms.enums;

import lombok.Getter;

@Getter
public enum Area {

    REDES_INFORMATICA("Redes e Informatica"),
    ELECTROMECANICA("Electromecanica"),
    PERIMETRAL("Perimetral"),
    SOPORTE("Soporte a la Operacion");

    private final String name;

    Area(final String name) {
        this.name = name;
    }

}
