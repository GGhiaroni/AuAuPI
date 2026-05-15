package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

public class FinalizarReservaCaseImpl implements  FinalizarReservaCase{
    private final ReservaGateway reservaGateway;

    public FinalizarReservaCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public Reserva execute(Long id) {
        Reserva reserva = reservaGateway.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Reserva de id " + id + " não encontrada."));

        return reservaGateway.save(reserva.finalizar());
    }
}
