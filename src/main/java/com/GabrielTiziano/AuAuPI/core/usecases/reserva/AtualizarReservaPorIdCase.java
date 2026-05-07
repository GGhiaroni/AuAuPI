package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;

public interface AtualizarReservaPorIdCase {
    public Reserva execute(Long id);
}
