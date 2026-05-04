package com.GabrielTiziano.AuAuPI.core.entities.enums;

public enum Sexo {
    MACHO("Macho"),
    FEMEA("Fêmea");

    private final String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return descricao;
    }
}
