package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

import java.util.List;

public class ListarReservasPorCachorroIdCaseImpl implements ListarReservasPorCachorroIdCase {
    private final ReservaGateway reservaGateway;
    private final CachorroGateway cachorroGateway;

    public ListarReservasPorCachorroIdCaseImpl(ReservaGateway reservaGateway, CachorroGateway cachorroGateway) {
        this.reservaGateway = reservaGateway;
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public List<Reserva> execute(Long cachorroId) {
        if(!cachorroGateway.existsById(cachorroId)) {
            throw new IllegalArgumentException("Não foi possível localizar um cachorro de id " + cachorroId + ".");
        }

        return reservaGateway.findByIdCachorro(cachorroId);
    }
}
