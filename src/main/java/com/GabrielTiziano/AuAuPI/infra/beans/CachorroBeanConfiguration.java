package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.*;
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

    @Bean
    public ListarCachorrosPorTutorCase listarCachorrosPorTutorCase(TutorGateway tutorGateway, CachorroGateway cachorroGateway){
        return new ListarCachorrosPorTutorCaseImpl(tutorGateway, cachorroGateway);
    }

    @Bean
    public ListarCachorrosCase listarCachorrosCase(CachorroGateway cachorroGateway){
        return new ListarCachorrosCaseImpl(cachorroGateway);
    }

    @Bean
    public AtualizarCachorroCase atualizarCachorroCase(CachorroGateway cachorroGateway, TutorGateway tutorGateway){
        return new AtualizarCachorroCaseImpl(cachorroGateway, tutorGateway);
    }

    @Bean
    public DeletarCachorroCase deletarCachorroCase(CachorroGateway cachorroGateway){
        return new DeletarCachorroCaseImpl(cachorroGateway);
    }

    @Bean
    public ListarCachorrosPorPorteCase listarCachorrosPorPorteCase(CachorroGateway cachorroGateway){
        return new ListarCachorrosPorPorteCaseImpl(cachorroGateway);
    }
}
