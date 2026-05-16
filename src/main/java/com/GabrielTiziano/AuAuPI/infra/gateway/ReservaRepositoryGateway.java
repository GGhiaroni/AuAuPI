package com.GabrielTiziano.AuAuPI.infra.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.CachorroFrequente;
import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import com.GabrielTiziano.AuAuPI.core.gateway.ReservaGateway;
import com.GabrielTiziano.AuAuPI.infra.mapper.ReservaMapper;
import com.GabrielTiziano.AuAuPI.infra.persistence.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReservaRepositoryGateway implements ReservaGateway {
    private final ReservaRepository reservaRepository;
    private final CachorroRepository cachorroRepository;

    @Override
    public Reserva save(Reserva reserva) {
        CachorroEntity cachorroEntity = cachorroRepository.findById(reserva.idCachorro())
                .orElseThrow(() -> new IllegalStateException(
                        "Cachorro inexistente ao salvar reserva: " + reserva.idCachorro()
                ));

        return ReservaMapper.toDomain(
                reservaRepository.save(
                        ReservaMapper.toEntity(
                                reserva, cachorroEntity
                        )));
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id)
                .map(ReservaMapper::toDomain);
    }

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll()
                .stream().map(ReservaMapper::toDomain)
                .toList();
    }

    @Override
    public List<Reserva> findByIdCachorro(Long idCachorro) {
        return reservaRepository.findByCachorroId(idCachorro)
                .stream().map(ReservaMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return reservaRepository.existsById(id);
    }

    @Override
    public List<Reserva> findByStatus(StatusReserva status) {
        return reservaRepository.findByStatus(status)
                .stream().map(ReservaMapper::toDomain)
                .toList();
    }

    @Override
    public List<Reserva> findByCheckin(LocalDate checkin) {
        return reservaRepository.findByDataCheckin(checkin)
                .stream()
                .map(ReservaMapper::toDomain)
                .toList();
    }

    @Override
    public List<Reserva> findByPeriodo(LocalDate inicio, LocalDate fim) {
        return reservaRepository.findByPeriodo(inicio, fim)
                .stream().map(ReservaMapper::toDomain)
                .toList();
    }

    @Override
    public List<Reserva> findByTutorId(Long id) {
        return reservaRepository.findByTutorId(id)
                .stream()
                .map(ReservaMapper::toDomain)
                .toList();
    }

    @Override
    public List<CachorroFrequente> listarCachorrosFrequentes(int limite) {
        return reservaRepository.findCachorrosFrequentes(PageRequest.of(0, limite));
    }
}
