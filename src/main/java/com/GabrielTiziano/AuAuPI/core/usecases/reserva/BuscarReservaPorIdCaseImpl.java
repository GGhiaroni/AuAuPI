package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

public class BuscarReservaPorIdImpl implements  BuscarReservaPorIdCase{
    private final ReservaGateway reservaGateway;

    public BuscarReservaPorIdImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public Reserva execute(Long id) {
        return reservaGateway.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "Reserva de id " + id + " não encontrada."
        ));
    }
}
