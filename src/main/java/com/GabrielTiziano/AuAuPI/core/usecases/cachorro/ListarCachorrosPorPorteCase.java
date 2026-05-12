package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.enums.Porte;

import java.util.List;

public interface ListarCachorrosPorPorteCase {
    List<Cachorro> execute(Porte porte);
}
