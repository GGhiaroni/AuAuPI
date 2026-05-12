package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

import java.time.LocalDate;
import java.util.List;

public class ListarReservasPorCheckinCaseImpl implements ListarReservasPorCheckinCase {
    private final ReservaGateway reservaGateway;

    public ListarReservasPorCheckinCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public List<Reserva> execute(LocalDate checkin) {
        return reservaGateway.findByCheckin(checkin);
    }
}
