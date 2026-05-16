package com.GabrielTiziano.AuAuPI.core.usecases.relatorio;

import com.GabrielTiziano.AuAuPI.core.entities.TutorFrequente;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

import java.util.List;

public class ListarTutoresFrequentesCaseImpl implements ListarTutoresFrequentesCase {
    private final ReservaGateway reservaGateway;

    public ListarTutoresFrequentesCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public List<TutorFrequente> execute(int limite) {
        if (limite <= 0) {
            throw new IllegalArgumentException("'limite' deve ser maior que zero.");
        }
        if (limite > 100) {
            throw new IllegalArgumentException("'limite' não pode exceder 100.");
        }
        return reservaGateway.listarTutoresFrequentes(limite);
    }
}
