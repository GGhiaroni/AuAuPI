package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

import java.time.LocalDate;
import java.util.List;

public class ListarReservasPorPeriodoCaseImpl implements ListarReservasPorPeriodoCase {
    private final ReservaGateway reservaGateway;

    public ListarReservasPorPeriodoCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public List<Reserva> execute(LocalDate inicio, LocalDate fim) {
        if (inicio == null || fim == null) {
            throw new IllegalArgumentException("Filtro por período exige 'inicio' e 'fim'.");
        }
        if (fim.isBefore(inicio)) {
            throw new IllegalArgumentException("'fim' deve ser maior ou igual a 'inicio'.");
        }
        return reservaGateway.findByPeriodo(inicio, fim);
    }
}
