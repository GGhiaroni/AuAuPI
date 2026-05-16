package com.GabrielTiziano.AuAuPI.core.entities;

import com.GabrielTiziano.AuAuPI.core.enums.Porte;

public record CachorroFrequente(
        Long idCachorro,
        String nome,
        String raca,
        Porte porte,
        Long quantidadeReservas
) {}
