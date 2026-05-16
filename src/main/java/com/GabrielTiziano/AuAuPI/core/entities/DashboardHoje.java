package com.GabrielTiziano.AuAuPI.core.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DashboardHoje(
        LocalDate data,
        long checkInsHoje,
        long checkOutsHoje,
        long hospedados,
        long reservasPendentes,
        BigDecimal receitaPrevistaSemana
) {
}
