package com.GabrielTiziano.AuAuPI.core.entities.enums;

import lombok.Getter;

@Getter
public enum Porte {
    PEQUENO("Cachorro de porte pequeno, abaixo de 10kgs."),
    MEDIO("Cachorro de porte médio, acima de 10kgs."),
    GRANDE("Cachorro de porte grande, acima de 18kgs."),
    GIGANTE("Cachorro de tamanho gigante, acima de 30kgs.");

    private final String description;

    Porte(String description) {
        this.description = description;
    }
}
