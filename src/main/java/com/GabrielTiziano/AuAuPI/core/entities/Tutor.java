package com.GabrielTiziano.AuAuPI.core.entities;

import java.time.LocalDateTime;

public record Tutor(
        Long id,
        String nome,
        String cpf,
        String email,
        String endereco,
        String telefone,
        LocalDateTime createdAt
) {}
