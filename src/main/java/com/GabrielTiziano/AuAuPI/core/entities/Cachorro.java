package com.GabrielTiziano.AuAuPI.core.entities;

import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;

import java.time.LocalDate;

public record Cachorro(
        Long id,
        String nome,
        String raca,
        Porte porte,
        Double peso,
        LocalDate dataDeNascimento,
        Sexo sexo,
        boolean castrado,
        String observacoesMedicas,
        Long idTutor
) {}
