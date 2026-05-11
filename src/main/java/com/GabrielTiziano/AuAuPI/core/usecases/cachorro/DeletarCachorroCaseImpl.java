package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;

public class DeletarCachorroCaseImpl implements DeletarCachorroCase{
    private final CachorroGateway cachorroGateway;

    public DeletarCachorroCaseImpl(CachorroGateway cachorroGateway) {
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public void execute(Long id) {
        cachorroGateway.deleteById(id);
    }
}
