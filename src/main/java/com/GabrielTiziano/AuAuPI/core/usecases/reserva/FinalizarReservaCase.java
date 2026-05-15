package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;

public interface FinalizarReservaCase {
    Reserva execute(Long id);
}
