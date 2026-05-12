package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;

import java.util.List;

public interface ListarCachorrosPorSexoCase {
    List<Cachorro> execute(Sexo sexo);
}
