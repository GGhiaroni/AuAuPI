package com.GabrielTiziano.AuAuPI.infra.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;


public record CriarReservaRequest(
        @NotNull(message = "Id do cachorro é obrigatório.")
        @Positive(message = "Id do cachorro deve ser positivo.")
        Long idCachorro,

        @NotNull(message = "Data de check-in é obrigatória.")
        @FutureOrPresent(message = "Data de check-in não pode estar no passado.")
        LocalDate dataCheckin,

        @NotNull(message = "Data de check-out é obrigatória.")
        @Future(message = "Data de check-out deve estar no futuro.")
        LocalDate dataCheckout,

        @NotNull(message = "Valor da diária é obrigatório.")
        @DecimalMin(value = "0.01", message = "Valor da diária deve ser maior que zero.")
        @Digits(integer = 8, fraction = 2, message = "Valor da diária deve ter no máximo 8 dígitos inteiros e 2 decimais.")
        BigDecimal valorDiaria,

        @Size(max = 2000, message = "Observações devem ter no máximo 2000 caracteres.")
        String observacoes
) {
}

