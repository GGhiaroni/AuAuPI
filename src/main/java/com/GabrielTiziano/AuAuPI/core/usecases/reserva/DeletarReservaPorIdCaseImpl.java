package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

public class DeletarReservaPorIdCaseImpl implements DeletarReservaPorIdCase {
    private final ReservaGateway reservaGateway;

    public DeletarReservaPorIdCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public void execute(Long id) {
        Reserva reserva = reservaGateway.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Reserva de id " + id + " não encontrada."));

        if (reserva.status() != StatusReserva.PENDENTE) {
            throw new IllegalStateException(
                    "Só é possível deletar reservas com status PENDENTE. " +
                            "Para reservas em outros estados, use o endpoint de cancelamento."
            );
        }

        reservaGateway.deleteById(id);
    }
}
