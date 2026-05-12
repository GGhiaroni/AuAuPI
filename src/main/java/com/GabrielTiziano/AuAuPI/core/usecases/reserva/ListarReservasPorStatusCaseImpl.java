package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

import java.util.List;

public class ListarReservasPorStatusCaseImpl implements ListarReservasPorStatusCase{
    private final ReservaGateway reservaGateway;

    public ListarReservasPorStatusCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public List<Reserva> execute(StatusReserva statusReserva) {
        return reservaGateway.findByStatus(statusReserva);
    }
}
