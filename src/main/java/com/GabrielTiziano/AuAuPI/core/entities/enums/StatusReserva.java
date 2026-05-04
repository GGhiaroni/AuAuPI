package com.GabrielTiziano.AuAuPI.core.entities.enums;

public enum StatusReserva {
    PENDENTE("Reserva pendente."),
    CONFIRMADA("Reserva confirmada."),
    EM_ANDAMENTO("Reserva em andamento."),
    FINALIZADA("Reserva finalizada."),
    CANCELADA("Reserva cancelada.");

    private final String descricao;

    StatusReserva(String descricao) {
        this.descricao = descricao;
    }

    public String descricao(){
        return descricao;
    }
}
