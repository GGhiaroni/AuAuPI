package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;

public interface BuscarTutorPorIdCase {
    public Tutor execute(Long id);
}
