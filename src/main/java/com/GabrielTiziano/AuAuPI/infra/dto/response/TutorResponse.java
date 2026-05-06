package com.GabrielTiziano.AuAuPI.infra.dto.response;

import java.time.LocalDateTime;

public record TutorResponse(
        Long id,
        String nome,
        String cpf,
        String email,
        String endereco,
        String telefone,
        LocalDateTime createdAt
) {
}
