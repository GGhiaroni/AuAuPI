package com.GabrielTiziano.AuAuPI.core.entities;

import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;

import java.time.LocalDate;
import java.time.Period;

public record Cachorro(
        Long id,
        String nome,
        String raca,
        Porte porte,
        Double peso,
        LocalDate dataNascimento,
        Sexo sexo,
        boolean castrado,
        String observacoesMedicas,
        Long idTutor
) {
    public int calcularIdadeEmAnos() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public Period calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now());
    }
}
