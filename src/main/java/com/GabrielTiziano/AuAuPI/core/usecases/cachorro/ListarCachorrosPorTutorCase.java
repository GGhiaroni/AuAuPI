package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;

import java.util.List;

public interface ListarCachorrosPorTutorCase {
    public List<Cachorro> execute(Long id);
}
