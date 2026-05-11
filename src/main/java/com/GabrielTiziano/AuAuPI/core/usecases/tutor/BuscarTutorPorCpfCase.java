package com.GabrielTiziano.AuAuPI.core.usecases.tutor;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;

public interface BuscarTutorPorCpfCase {
    Tutor execute(String cpf);
}
