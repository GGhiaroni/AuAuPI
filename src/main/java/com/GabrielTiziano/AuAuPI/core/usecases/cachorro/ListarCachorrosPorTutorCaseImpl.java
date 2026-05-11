package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

import java.util.List;

public class ListarCachorrosPorTutorCaseImpl implements  ListarCachorrosPorTutorCase{
    private final TutorGateway tutorGateway;
    private final CachorroGateway cachorroGateway;

    public ListarCachorrosPorTutorCaseImpl(TutorGateway tutorGateway, CachorroGateway cachorroGateway) {
        this.tutorGateway = tutorGateway;
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public List<Cachorro> execute(Long id) {
        if (!tutorGateway.existsById(id)) {
            throw new IllegalArgumentException(
                    "Tutor de id " + id + " não encontrado."
            );
        }
        return cachorroGateway.findByTutorId(id);
    }
}
