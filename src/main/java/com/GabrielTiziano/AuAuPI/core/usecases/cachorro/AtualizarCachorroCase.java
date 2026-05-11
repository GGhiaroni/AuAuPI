package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;

public interface AtualizarCachorroCase {
    Cachorro execute(Long id, Cachorro cachorro);
}
