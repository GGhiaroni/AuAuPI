package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.dashboard.ObterDashboardHojeCase;
import com.GabrielTiziano.AuAuPI.core.usecases.dashboard.ObterDashboardHojeCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DashboardBeanConfiguration {
    @Bean
    public ObterDashboardHojeCase obterDashboardHojeCase(ReservaGateway reservaGateway) {
        return new ObterDashboardHojeCaseImpl(reservaGateway);
    }
}
