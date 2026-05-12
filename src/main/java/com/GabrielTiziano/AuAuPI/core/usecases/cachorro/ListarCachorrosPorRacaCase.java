package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;

import java.util.List;

public interface ListarCachorrosPorRacaCase {
    List<Cachorro> execute(String raca);
}
