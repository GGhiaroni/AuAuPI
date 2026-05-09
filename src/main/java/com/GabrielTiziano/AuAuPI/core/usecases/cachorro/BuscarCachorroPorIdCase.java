package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;

public interface BuscarCachorroPorIdCase {
    public Cachorro execute(Long id);
}
