package com.GabrielTiziano.AuAuPI.infra.beans;

import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.*;
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

    @Bean
    DeletarTutorPorIdCase deletarTutorPorIdCase(TutorGateway tutorGateway){
        return new DeletarTutorPorIdCaseImpl(tutorGateway);
    }

    @Bean
    ListarTutoresCase listarTutoresCase(TutorGateway tutorGateway){
        return new ListarTutoresCaseImpl(tutorGateway);
    }

    @Bean
    AtualizarTutorPorIdCase atualizarTutorPorIdCase(TutorGateway tutorGateway){
        return new AtualizarTutorPorIdCaseImpl(tutorGateway);
    }

    @Bean
    BuscarTutorPorCpfCase buscarTutorPorCpfCase(TutorGateway tutorGateway){
        return new BuscarTutorPorCpfCaseImpl(tutorGateway);
    }

    @Bean
    BuscarTutorPorNomeCase buscarTutorPorNomeCase(TutorGateway tutorGateway){
        return new BuscarTutorPorNomeCaseImpl(tutorGateway);
    }
}
