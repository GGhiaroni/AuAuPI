package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

import java.util.List;

public class ListarReservasPorTutorCaseImpl implements ListarReservasPorTutorCase{
    private final ReservaGateway reservaGateway;
    private final TutorGateway tutorGateway;

    public ListarReservasPorTutorCaseImpl(ReservaGateway reservaGateway, TutorGateway tutorGateway) {
        this.reservaGateway = reservaGateway;
        this.tutorGateway = tutorGateway;
    }

    @Override
    public List<Reserva> execute(Long id) {
        if(!tutorGateway.existsById(id)) {
            throw new IllegalArgumentException("Não foi possível localizar um tutor de id " + id + ".");
        }

        return reservaGateway.findByTutorId(id);
    }
}
