package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;

import java.util.List;

public interface ListarReservasPorTutorCase {
    List<Reserva> execute(Long id);
}
