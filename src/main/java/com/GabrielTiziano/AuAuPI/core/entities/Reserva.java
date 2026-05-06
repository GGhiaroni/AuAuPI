package com.GabrielTiziano.AuAuPI.core.entities;

import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record Reserva (
        Long id,
        Long idCachorro,
        LocalDate dataCheckin,
        LocalDate dataCheckout,
        StatusReserva status,
        BigDecimal valorDiaria,
        String observacoes
){
    public long calcularQuantidadeDiarias() {
        return ChronoUnit.DAYS.between(dataCheckin, dataCheckout);
    }

    public BigDecimal calcularValorTotal() {
        return valorDiaria.multiply(BigDecimal.valueOf(calcularQuantidadeDiarias()));
    }
}
