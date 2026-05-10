package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;

public interface BuscarTutorPorCpfCase {
    public Tutor execute(String cpf);
}
