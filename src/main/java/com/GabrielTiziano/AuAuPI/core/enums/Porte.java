package com.GabrielTiziano.AuAuPI.core.enums;

public enum Porte {
    PEQUENO("Cachorro de porte pequeno, abaixo de 10kg."),
    MEDIO("Cachorro de porte médio, entre 10kg e 18kg."),
    GRANDE("Cachorro de porte grande, entre 18kg e 30kg."),
    GIGANTE("Cachorro de tamanho gigante, acima de 30kg.");

    private final String descricao;

    Porte(String descricao) {
        this.descricao = descricao;
    }

    public String descricao(){
        return descricao;
    }
}
