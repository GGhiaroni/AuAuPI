package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;

import java.util.List;

public interface BuscarTutorPorNomeCase {
    public List<Tutor> execute(String nome);
}
