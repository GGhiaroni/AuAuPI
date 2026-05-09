package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.BuscarCachorroPorIdCase;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.BuscarCachorroPorIdCaseImpl;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.CriarCachorroCase;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.CriarCachorroCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CachorroBeanConfiguration {
    @Bean
    public CriarCachorroCase criarCachorroCase(CachorroGateway cachorroGateway, TutorGateway tutorGateway) {
        return new CriarCachorroCaseImpl(cachorroGateway, tutorGateway);
    }
    @Bean
    public BuscarCachorroPorIdCase buscarCachorroPorIdCase(CachorroGateway cachorroGateway){
        return new BuscarCachorroPorIdCaseImpl(cachorroGateway);
    }
}
