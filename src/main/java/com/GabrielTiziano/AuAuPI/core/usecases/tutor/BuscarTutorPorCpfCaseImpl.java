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
        String cpfNormalizado = cpf.replaceAll("[^0-9]", "");

        return tutorGateway.findByCpf(cpfNormalizado) .orElseThrow(() -> new IllegalArgumentException(
                "Tutor de CPF: " + cpf + " não encontrado."
        ));
    }
}
