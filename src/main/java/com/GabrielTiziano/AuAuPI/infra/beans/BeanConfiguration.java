package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.CriarCachorroCase;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.CriarCachorroCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CriarCachorroCase criarCachorroCase(CachorroGateway cachorroGateway) {
        return new CriarCachorroCaseImpl(cachorroGateway);
    }
}
