package com.GabrielTiziano.AuAuPI.core.usecases.relatorio;

import com.GabrielTiziano.AuAuPI.core.entities.CachorroFrequente;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

import java.util.List;

public class ListarCachorrosFrequentesCaseImpl implements  ListarCachorrosFrequentesCase{
    private final ReservaGateway reservaGateway;

    public ListarCachorrosFrequentesCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public List<CachorroFrequente> execute(int limite) {
        if (limite <= 0) {
            throw new IllegalArgumentException("'limite' deve ser maior que zero.");
        }
        if (limite > 100) {
            throw new IllegalArgumentException("'limite' não pode exceder 100.");
        }
        return reservaGateway.listarCachorrosFrequentes(limite);
    }
}
