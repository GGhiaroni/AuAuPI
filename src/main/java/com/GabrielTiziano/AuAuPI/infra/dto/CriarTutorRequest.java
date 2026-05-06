package com.GabrielTiziano.AuAuPI.infra.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CriarTutorRequest(
        @NotBlank(message = "Nome é obrigatório.")
        @Size(max = 120, message = "Nome deve ter no máximo 120 caracteres.")
        String nome,
        @NotBlank(message = "CPF é obrigatório.")
        @CPF(message = "CPF inválido.")
        String cpf,
        @NotBlank(message = "E-mail é obrigatório.")
        @Email(message = "E-mail inválido.")
        @Size(max = 150, message = "E-mail deve ter no máximo 150 caracteres.")
        String email,
        @NotBlank(message = "Endereço é obrigatório.")
        @Size(max = 200, message = "Endereço deve ter no máximo 200 caracteres.")
        String endereco,
        @NotBlank(message = "Telefone é obrigatório.")
        @Pattern(
                regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}",
                message = "Telefone deve estar no formato (XX) XXXXX-XXXX."
        )
        String telefone
) {
}
