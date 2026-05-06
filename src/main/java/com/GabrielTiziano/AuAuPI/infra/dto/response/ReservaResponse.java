package com.GabrielTiziano.AuAuPI.infra.dto.response;

import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservaResponse (
        Long id,
        CachorroResumoResponse cachorro,
        LocalDate dataCheckin,
        LocalDate dataCheckout,
        StatusReserva status,
        BigDecimal valorDiaria,
        long quantidadeDiarias,
        BigDecimal valorTotal,
        String observacoes
){
}
