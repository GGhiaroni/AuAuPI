package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;

import java.util.List;

public class ListarCachorrosPorPorteCaseImpl implements  ListarCachorrosPorPorteCase{
    private final CachorroGateway cachorroGateway;

    public ListarCachorrosPorPorteCaseImpl(CachorroGateway cachorroGateway) {
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public List<Cachorro> execute(Porte porte) {
       return cachorroGateway.findByPorte(porte);
    }
}
