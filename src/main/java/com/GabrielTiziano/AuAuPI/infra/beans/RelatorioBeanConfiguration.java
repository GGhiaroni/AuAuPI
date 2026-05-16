package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.relatorio.ListarCachorrosFrequentesCase;
import com.GabrielTiziano.AuAuPI.core.usecases.relatorio.ListarCachorrosFrequentesCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RelatorioBeanConfiguration {
    @Bean
    public ListarCachorrosFrequentesCase listarCachorrosFrequentesCase(
            ReservaGateway reservaGateway) {
        return new ListarCachorrosFrequentesCaseImpl(reservaGateway);
    }
}
