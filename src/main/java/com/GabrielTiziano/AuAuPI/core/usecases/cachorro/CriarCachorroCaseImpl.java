package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarCachorroCaseImpl implements CriarCachorroCase{
    private final CachorroGateway cachorroGateway;

    @Override
    public Cachorro execute(Cachorro cachorro) {
        return null;
    }
}
