package com.GabrielTiziano.AuAuPI.core.usecases.relatorio;

import com.GabrielTiziano.AuAuPI.core.entities.TutorFrequente;

import java.util.List;

public interface ListarTutoresFrequentesCase {
    List<TutorFrequente> execute(int limite);
}
