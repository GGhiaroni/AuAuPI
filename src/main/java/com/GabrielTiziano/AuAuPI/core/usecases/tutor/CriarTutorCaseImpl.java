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
        String cpfNormalizado = tutor.cpf().replaceAll("[^0-9]", "");
        if(tutorGateway.existsByCpf(cpfNormalizado)){
            throw new IllegalArgumentException(
                    "Tutor com CPF: " + cpfNormalizado + " já cadastrado."
            );
        }

        Tutor tutorASalvar = new Tutor(
                null,
                tutor.nome(),
                cpfNormalizado,
                tutor.email(),
                tutor.endereco(),
                tutor.telefone(),
                LocalDateTime.now()
        );

        return tutorGateway.save(tutorASalvar);
    }
}
