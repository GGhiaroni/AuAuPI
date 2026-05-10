package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

public class BuscarTutorPorCpfCaseImpl implements BuscarTutorPorCpfCase {
    private final TutorGateway tutorGateway;

    public BuscarTutorPorCpfCaseImpl(TutorGateway tutorGateway) {
        this.tutorGateway = tutorGateway;
    }

    @Override
    public Tutor execute(String cpf) {
        return tutorGateway.findByCpf(cpf) .orElseThrow(() -> new IllegalArgumentException(
                "Tutor de CPF: " + cpf + " não encontrado."
        ));
    }
}
