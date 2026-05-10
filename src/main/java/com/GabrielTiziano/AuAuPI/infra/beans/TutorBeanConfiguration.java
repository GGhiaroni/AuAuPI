package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.BuscarTutorPorIdCase;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.BuscarTutorPorIdCaseImpl;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.CriarTutorCase;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.CriarTutorCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TutorBeanConfiguration {
    @Bean
    public CriarTutorCase criarTutorCase(TutorGateway tutorGateway){
        return new CriarTutorCaseImpl(tutorGateway);
    }
    @Bean
    public BuscarTutorPorIdCase buscarTutorPorIdCase(TutorGateway tutorGateway) {
        return new BuscarTutorPorIdCaseImpl(tutorGateway);
    }
}
