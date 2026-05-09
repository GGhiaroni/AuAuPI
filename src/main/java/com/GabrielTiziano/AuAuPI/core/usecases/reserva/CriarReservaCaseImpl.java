package com.GabrielTiziano.AuAuPI.core.usecases.reserva;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

public class CriarReservaCaseImpl implements  CriarReservaCase{
    private final CachorroGateway cachorroGateway;
    private final ReservaGateway reservaGateway;

    public CriarReservaCaseImpl(CachorroGateway cachorroGateway, ReservaGateway reservaGateway) {
        this.cachorroGateway = cachorroGateway;
        this.reservaGateway = reservaGateway;
    }

    @Override
    public Reserva execute(Reserva reserva) {
        if(!cachorroGateway.existsById(reserva.idCachorro())){
            throw new IllegalArgumentException(
                    "Cachorro de id " + reserva.idCachorro() + " não encontrado."
            );
        }

        Reserva reservaASalvar = new Reserva(
                null,
                reserva.idCachorro(),
                reserva.dataCheckin(),
                reserva.dataCheckout(),
                StatusReserva.PENDENTE,
                reserva.valorDiaria(),
                reserva.observacoes()
        );

        return reservaGateway.save(reservaASalvar);
    }
}
