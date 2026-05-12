package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;

import java.util.List;

public class ListarCachorrosPorRacaCaseImpl implements  ListarCachorrosPorRacaCase{
    private final CachorroGateway cachorroGateway;

    public ListarCachorrosPorRacaCaseImpl(CachorroGateway cachorroGateway) {
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public List<Cachorro> execute(String raca) {
        if (raca == null || raca.isBlank()) {
            throw new IllegalArgumentException("Termo de busca não pode ser vazio.");
        }
        String racaTratada = raca.trim();
        if (racaTratada.length() < 2) {
            throw new IllegalArgumentException("Termo de busca deve ter pelo menos 2 caracteres.");
        }
        return cachorroGateway.findByRaca(racaTratada);
    }
}
