package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

import java.util.Optional;

public class DeletarTutorPorIdCaseImpl implements DeletarTutorPorIdCase{
    private final TutorGateway tutorGateway;

    public DeletarTutorPorIdCaseImpl(TutorGateway tutorGateway) {
        this.tutorGateway = tutorGateway;
    }

    @Override
    public void execute(Long id) {
        if (!tutorGateway.existsById(id)) {
            throw new IllegalArgumentException(
                    "Tutor de id " + id + " não encontrado."
            );
        }
        tutorGateway.deleteById(id);
    }
}
