package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

import java.util.List;

public class BuscarTutorPorNomeCaseImpl implements BuscarTutorPorNomeCase {
    private final TutorGateway tutorGateway;

    public BuscarTutorPorNomeCaseImpl(TutorGateway tutorGateway) {
        this.tutorGateway = tutorGateway;
    }

    @Override
    public List<Tutor> execute(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Termo de busca não pode ser vazio.");
        }
        String termoNormalizado = nome.trim();
        if (termoNormalizado.length() < 2) {
            throw new IllegalArgumentException(
                    "Termo de busca deve ter pelo menos 2 caracteres."
            );
        }
        return tutorGateway.findByNomeParcial(termoNormalizado);
    }
}
