package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;

import java.util.List;

public class ListarCachorrosCaseImpl implements ListarCachorrosCase{
    private final CachorroGateway cachorroGateway;

    public ListarCachorrosCaseImpl(CachorroGateway cachorroGateway) {
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public List<Cachorro> execute() {
       return cachorroGateway.findAll();
    }
}
