package com.GabrielTiziano.AuAuPI.infra.dto.response;

import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;

import java.time.LocalDate;

public record CachorroResumoResponse(
        Long id,
        String nome,
        String raca,
        Porte porte,
        Double peso
) {
}
