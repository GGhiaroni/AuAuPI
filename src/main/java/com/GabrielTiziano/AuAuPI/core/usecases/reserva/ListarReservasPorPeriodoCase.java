package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;

import java.time.LocalDate;
import java.util.List;

public interface ListarReservasPorPeriodoCase {
    List<Reserva> execute(LocalDate inicio, LocalDate fim);
}
