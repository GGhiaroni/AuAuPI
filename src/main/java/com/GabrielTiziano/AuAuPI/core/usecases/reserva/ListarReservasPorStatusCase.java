package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;

import java.util.List;

public interface ListarReservasPorStatusCase {
    List<Reserva> execute(StatusReserva statusReserva);
}
