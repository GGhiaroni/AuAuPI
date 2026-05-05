package com.GabrielTiziano.AuAuPI.core.entities;

import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Reserva (
        Long id,
        Long idCachorro,
        LocalDateTime dataCheckin,
        LocalDateTime dataCheckout,
        StatusReserva status,
        BigDecimal valorDiaria,
        String observacoes
){ }
