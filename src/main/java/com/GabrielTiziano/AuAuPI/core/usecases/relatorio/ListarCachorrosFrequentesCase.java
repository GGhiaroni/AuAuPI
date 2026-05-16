package com.GabrielTiziano.AuAuPI.core.usecases.relatorio;

import com.GabrielTiziano.AuAuPI.core.entities.CachorroFrequente;

import java.util.List;

public interface ListarCachorrosFrequentesCase {
    List<CachorroFrequente> execute(int limite);
}
