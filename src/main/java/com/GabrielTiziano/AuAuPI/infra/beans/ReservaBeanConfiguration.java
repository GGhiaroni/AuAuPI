package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.*;
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

    @Bean
    public BuscarReservaPorIdCase buscarReservaPorIdCase(ReservaGateway reservaGateway){
        return new BuscarReservaPorIdCaseImpl(reservaGateway);
    }

    @Bean
    public DeletarReservaPorIdCase deletarReservaPorIdCase(ReservaGateway reservaGateway){
        return new DeletarReservaPorIdCaseImpl(reservaGateway);
    }

    @Bean
    public ListarReservasCase listarReservasCase(ReservaGateway reservaGateway){
        return new ListarReservasCaseImpl(reservaGateway);
    }

    @Bean
    public ListarReservasPorStatusCase listarReservasPorStatusCase(ReservaGateway reservaGateway){
        return new ListarReservasPorStatusCaseImpl(reservaGateway);
    }

    @Bean
    public ListarReservasPorCheckinCase listarReservasPorCheckinCase(ReservaGateway reservaGateway){
        return new ListarReservasPorCheckinCaseImpl(reservaGateway);
    }

    @Bean
    public ListarReservasPorPeriodoCase listarReservasPorPeriodoCase(ReservaGateway reservaGateway){
        return new ListarReservasPorPeriodoCaseImpl(reservaGateway);
    }

    @Bean
    public ListarReservasPorTutorCase listarReservasPorTutorCase(ReservaGateway reservaGateway, TutorGateway tutorGateway){
        return new ListarReservasPorTutorCaseImpl(reservaGateway, tutorGateway);
    }

    @Bean
    public ConfirmarReservaCase confirmarReservaCase(ReservaGateway reservaGateway) {
        return new ConfirmarReservaCaseImpl(reservaGateway);
    }
}
