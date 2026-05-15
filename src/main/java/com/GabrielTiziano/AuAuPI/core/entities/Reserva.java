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

    public Reserva confirmar() {
        if (status != StatusReserva.PENDENTE) {
            throw new IllegalStateException(
                    "Reserva " + id + " não pode ser confirmada: status atual é " + status +
                            ". Só é possível confirmar reservas com status PENDENTE."
            );
        }
        return new Reserva(id, idCachorro, dataCheckin, dataCheckout,
                StatusReserva.CONFIRMADA, valorDiaria, observacoes);
    }

    public Reserva iniciar(){
        if(status != StatusReserva.CONFIRMADA) {
            throw new IllegalStateException(
                    "Reserva " + id + " não pode ser iniciada: status atual é " + status +
                            ". Só é possível iniciar reservas com status CONFIRMADA."
            );
        }

        return new Reserva(
                id, idCachorro, dataCheckin, dataCheckout,
                StatusReserva.EM_ANDAMENTO, valorDiaria, observacoes
        );
    }

    public Reserva finalizar(){
        if(status != StatusReserva.EM_ANDAMENTO) {
            throw new IllegalStateException(
                    "Reserva " + id + " não pode ser finalizada: status atual é " + status +
                            ". Só é possível finalizar reservas com status EM_ANDAMENTO."
            );
        }

        return new Reserva(
                id, idCachorro, dataCheckin, dataCheckout,
                StatusReserva.FINALIZADA, valorDiaria, observacoes
        );
    }

    public Reserva cancelar(){
        if (status == StatusReserva.FINALIZADA) {
            throw new IllegalStateException("Reserva já finalizada não pode ser cancelada.");
        }
        if (status == StatusReserva.CANCELADA) {
            throw new IllegalStateException("Reserva já está cancelada.");
        }

        return new Reserva(
                id, idCachorro, dataCheckin, dataCheckout,
                StatusReserva.CANCELADA, valorDiaria, observacoes
        );
    }
}
