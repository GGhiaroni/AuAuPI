package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;

public class BuscarCachorroPorIdCaseImpl implements BuscarCachorroPorIdCase {
    private final CachorroGateway cachorroGateway;

    public BuscarCachorroPorIdCaseImpl(CachorroGateway cachorroGateway) {
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public Cachorro execute(Long id) {
        return cachorroGateway.findById(id).orElseThrow(() -> new IllegalArgumentException(
                "Cachorro de id " + id + " não encontrado."
        ));
    }
}
