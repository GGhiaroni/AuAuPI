package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

public class BuscarTutorPorIdCaseImpl implements  BuscarTutorPorIdCase {

    private final TutorGateway tutorGateway;

    public BuscarTutorPorIdCaseImpl(TutorGateway tutorGateway) {
        this.tutorGateway = tutorGateway;
    }

    @Override
    public Tutor execute(Long id) {
        return tutorGateway.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Tutor não encontrado: " + id
                ));
    }
}
