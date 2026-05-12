package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;

import java.util.List;

public interface ListarReservasPorCachorroIdCase {
    List<Reserva> execute(Long cachorroId);
}
