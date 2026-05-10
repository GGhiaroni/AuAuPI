package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

import java.util.List;

public class ListarTutoresCaseImpl implements ListarTutoresCase{
    private final TutorGateway tutorGateway;

    public ListarTutoresCaseImpl(TutorGateway tutorGateway) {
        this.tutorGateway = tutorGateway;
    }

    @Override
    public List<Tutor> execute() {
        return tutorGateway.findAll();
    }
}
