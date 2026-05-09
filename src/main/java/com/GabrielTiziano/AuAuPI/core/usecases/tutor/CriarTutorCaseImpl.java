package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

import java.time.LocalDateTime;

public class CriarTutorCaseImpl implements  CriarTutorCase{
    private final TutorGateway tutorGateway;

    public CriarTutorCaseImpl(TutorGateway tutorGateway) {
        this.tutorGateway = tutorGateway;
    }

    @Override
    public Tutor execute(Tutor tutor) {
        if(tutorGateway.existsByCpf(tutor.cpf())){
            throw new IllegalArgumentException(
                    "Tutor com CPF: " + tutor.cpf() + " já cadastrado."
            );
        }

        Tutor tutorASalvar = new Tutor(
                null,
                tutor.nome(),
                tutor.cpf(),
                tutor.email(),
                tutor.endereco(),
                tutor.telefone(),
                LocalDateTime.now()
        );

        return tutorGateway.save(tutorASalvar);
    }
}
