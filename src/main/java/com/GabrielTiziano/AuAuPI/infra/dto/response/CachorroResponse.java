package com.GabrielTiziano.AuAuPI.infra.dto.response;

import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;

import java.time.LocalDate;

public record CachorroResponse(
        Long id,
        String nome,
        String raca,
        Porte porte,
        Double peso,
        int idadeEmAnos,
        Sexo sexo,
        boolean castrado,
        String observacoesMedicas,
        TutorResumoResponse tutor
) {
}
