package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

public class ConfirmarReservaCaseImpl implements ConfirmarReservaCase{
    private final ReservaGateway reservaGateway;

    public ConfirmarReservaCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public Reserva execute(Long id) {
        Reserva reserva = reservaGateway.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Reserva de id " + id + " não encontrada."));

        return reservaGateway.save(reserva.confirmar());
    }
}
