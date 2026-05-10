package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

import java.util.Optional;

public class AtualizarTutorPorIdCaseImpl implements AtualizarTutorPorIdCase{
    private final TutorGateway tutorGateway;

    public AtualizarTutorPorIdCaseImpl(TutorGateway tutorGateway) {
        this.tutorGateway = tutorGateway;
    }

    @Override
    public Tutor execute(Long id, Tutor tutor) {
        Optional<Tutor> tutorExistente = tutorGateway.findById(id);

        if(tutorExistente.isEmpty()){
            throw new IllegalArgumentException("Não foi possível localizar um tutor de id " + id + ".");
        }

        String cpfNormalizado = tutor.cpf().replaceAll("[^0-9]", "");

        if (!tutorExistente.get().cpf().equals(cpfNormalizado)
                && tutorGateway.existsByCpf(cpfNormalizado)) {
            throw new IllegalArgumentException(
                    "CPF " + cpfNormalizado + " já está cadastrado por outro tutor."
            );
        }

        Tutor tutorASalvar = new Tutor(
          tutorExistente.get().id(),
                tutor.nome(),
                cpfNormalizado,
                tutor.email(),
                tutor.endereco(),
                tutor.telefone(),
                tutorExistente.get().createdAt()
        );

        return tutorGateway.save(tutorASalvar);
    }
}
