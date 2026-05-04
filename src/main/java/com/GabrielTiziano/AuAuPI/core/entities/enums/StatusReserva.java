package com.GabrielTiziano.AuAuPI.core.entities.enums;

import lombok.Getter;

@Getter
public enum StatusReserva {
    PENDENTE("Reserva pendente."),
    CONFIRMADA("Reserva confirmada."),
    EM_ANDAMENTO("Reserva em andamento."),
    FINALIZADA("Reserva finalizada."),
    CANCELADA("Reserva cancelada.");

    private final String description;

    StatusReserva(String description) {
        this.description = description;
    }
}
