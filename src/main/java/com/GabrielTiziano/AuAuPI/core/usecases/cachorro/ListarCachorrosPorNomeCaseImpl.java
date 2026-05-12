package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;

import java.util.List;

public class ListarCachorrosPorNomeCaseImpl implements ListarCachorrosPorNomeCase{
    private final CachorroGateway cachorroGateway;

    public ListarCachorrosPorNomeCaseImpl(CachorroGateway cachorroGateway) {
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public List<Cachorro> execute(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Termo de busca não pode ser vazio.");
        }
        String termo = nome.trim();
        if (termo.length() < 2) {
            throw new IllegalArgumentException("Termo de busca deve ter pelo menos 2 caracteres.");
        }
        return cachorroGateway.findByNome(termo);
    }
}
