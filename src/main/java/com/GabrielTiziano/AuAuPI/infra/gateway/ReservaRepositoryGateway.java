package com.GabrielTiziano.AuAuPI.infra.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ReservaRepositoryGateway implements ReservaGateway {
    @Override
    public Reserva save(Reserva reserva) {
        return null;
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Reserva> findAll() {
        return List.of();
    }

    @Override
    public List<Reserva> findByIdCachorro(Long idCachorro) {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public List<Reserva> findByStatus(StatusReserva status) {
        return List.of();
    }

    @Override
    public List<Reserva> findByPeriodo(LocalDate inicio, LocalDate fim) {
        return List.of();
    }
}
