package com.GabrielTiziano.AuAuPI.core.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.CachorroFrequente;
import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.entities.TutorFrequente;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservaGateway {
    Reserva save(Reserva reserva);
    Optional<Reserva> findById(Long id);
    List<Reserva> findAll();
    List<Reserva> findByIdCachorro(Long idCachorro);
    void deleteById(Long id);
    boolean existsById(Long id);
    List<Reserva> findByStatus(StatusReserva status);
    List<Reserva> findByCheckin(LocalDate checkin);
    List<Reserva> findByPeriodo(LocalDate inicio, LocalDate fim);
    List<Reserva> findByTutorId(Long id);
    List<CachorroFrequente> listarCachorrosFrequentes(int limite);
    List<TutorFrequente> listarTutoresFrequentes(int limite);
    long contarPorStatus(StatusReserva status);
    long contarCheckInsDoDia(LocalDate dia, StatusReserva status);
    long contarCheckOutsDoDia(LocalDate dia, StatusReserva status);
}
