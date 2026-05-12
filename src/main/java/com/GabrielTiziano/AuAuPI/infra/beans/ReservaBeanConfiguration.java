package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.CriarReservaCase;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.CriarReservaCaseImpl;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.ListarReservasPorCachorroIdCase;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.ListarReservasPorCachorroIdCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservaBeanConfiguration {
    @Bean
    public CriarReservaCase criarReservaCase(CachorroGateway cachorroGateway, ReservaGateway reservaGateway){
        return new CriarReservaCaseImpl(cachorroGateway, reservaGateway);
    }

    @Bean
    public ListarReservasPorCachorroIdCase listarReservasPorCachorroIdCase(ReservaGateway reservaGateway, CachorroGateway cachorroGateway){
        return new ListarReservasPorCachorroIdCaseImpl(reservaGateway, cachorroGateway);
    }
}
