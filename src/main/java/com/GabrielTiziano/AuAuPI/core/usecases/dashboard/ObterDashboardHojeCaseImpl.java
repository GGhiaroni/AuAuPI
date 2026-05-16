package com.GabrielTiziano.AuAuPI.core.usecases.dashboard;

import com.GabrielTiziano.AuAuPI.core.entities.DashboardHoje;
import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ObterDashboardHojeCaseImpl implements ObterDashboardHojeCase {
    private final ReservaGateway reservaGateway;

    public ObterDashboardHojeCaseImpl(ReservaGateway reservaGateway) {
        this.reservaGateway = reservaGateway;
    }

    @Override
    public DashboardHoje execute() {
        LocalDate hoje = LocalDate.now();
        LocalDate fimDaSemana = hoje.plusDays(6);

        long checkInsHoje = reservaGateway.contarCheckInsDoDia(
                hoje, StatusReserva.CONFIRMADA);

        long checkOutsHoje = reservaGateway.contarCheckOutsDoDia(
                hoje, StatusReserva.EM_ANDAMENTO);

        long hospedados = reservaGateway.contarPorStatus(StatusReserva.EM_ANDAMENTO);

        long reservasPendentes = reservaGateway.contarPorStatus(StatusReserva.PENDENTE);

        BigDecimal receitaPrevistaSemana = reservaGateway
                .findByPeriodo(hoje, fimDaSemana)
                .stream()
                .filter(r -> r.status() == StatusReserva.CONFIRMADA
                        || r.status() == StatusReserva.EM_ANDAMENTO)
                .map(Reserva::calcularValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new DashboardHoje(
                hoje,
                checkInsHoje,
                checkOutsHoje,
                hospedados,
                reservasPendentes,
                receitaPrevistaSemana
        );
    }
}
