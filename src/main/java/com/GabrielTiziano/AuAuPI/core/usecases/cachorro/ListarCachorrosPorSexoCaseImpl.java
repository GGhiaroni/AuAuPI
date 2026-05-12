package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;

import java.util.List;

public class ListarCachorrosPorSexoCaseImpl implements ListarCachorrosPorSexoCase{
   private final CachorroGateway cachorroGateway;

    public ListarCachorrosPorSexoCaseImpl(CachorroGateway cachorroGateway) {
        this.cachorroGateway = cachorroGateway;
    }

    @Override
    public List<Cachorro> execute(Sexo sexo) {
        return cachorroGateway.findBySexo(sexo);
    }
}
