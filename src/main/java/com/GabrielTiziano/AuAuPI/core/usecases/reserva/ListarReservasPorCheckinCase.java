package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface ListarReservasPorCheckinCase {
    List<Reserva> execute(LocalDate checkin);
}
