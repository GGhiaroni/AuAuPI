package com.GabrielTiziano.AuAuPI.infra.dto;

import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;

import java.time.LocalDate;

import jakarta.validation.constraints.*;

public record CriarCachorroRequest(
        @NotBlank(message = "Nome é obrigatório.")
        @Size(max = 80, message = "Nome deve ter no máximo 80 caracteres.")
        String nome,
        @NotBlank(message = "Raça é obrigatória.")
        @Size(max = 80, message = "Raça deve ter no máximo 80 caracteres.")
        String raca,
        @NotNull(message = "Porte é obrigatório.")
        Porte porte,
        @NotNull(message = "Peso é obrigatório.")
        @Positive(message = "Peso deve ser maior que zero.")
        Double peso,
        @NotNull(message = "Data de nascimento é obrigatória.")
        @PastOrPresent(message = "Data de nascimento não pode estar no futuro.")
        LocalDate dataNascimento,
        @NotNull(message = "Sexo é obrigatório.")
        Sexo sexo,
        @NotNull(message = "Indicar se é castrado é obrigatório.")
        Boolean castrado,
        @Size(max = 2000, message = "Observações médicas devem ter no máximo 2000 caracteres.")
        String observacoesMedicas,
        @NotNull(message = "Id do tutor é obrigatório.")
        @Positive(message = "Id do tutor deve ser positivo.")
        Long idTutor
) {
}
