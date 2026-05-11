package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;

public interface BuscarCachorroPorIdCase {
    Cachorro execute(Long id);
}
