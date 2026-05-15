package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.BuscarCachorroPorIdCase;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.*;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarReservaRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResumoResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.ReservaResponse;
import com.GabrielTiziano.AuAuPI.infra.mapper.CachorroMapper;
import com.GabrielTiziano.AuAuPI.infra.mapper.ReservaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final CriarReservaCase criarReservaCase;
    private final BuscarCachorroPorIdCase buscarCachorroPorIdCase;
    private final BuscarReservaPorIdCase buscarReservaPorIdCase;
    private final DeletarReservaPorIdCase deletarReservaPorIdCase;
    private final ListarReservasCase listarReservasCase;
    private final ListarReservasPorStatusCase listarReservasPorStatusCase;
    private final ListarReservasPorPeriodoCase listarReservasPorPeriodoCase;
    private final ListarReservasPorCheckinCase listarReservasPorCheckinCase;
    private final ConfirmarReservaCase confirmarReservaCase;
    private final IniciarReservaCase iniciarReservaCase;
    private final FinalizarReservaCase finalizarReservaCase;
    private final CancelarReservaCase cancelarReservaCase;

    @GetMapping
    public ResponseEntity<List<ReservaResponse>> listarReservas(
            @RequestParam(required = false) StatusReserva status,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin) {

        List<Reserva> reservas;

        if (status != null) {
            reservas = listarReservasPorStatusCase.execute(status);
        } else if (inicio != null || fim != null) {
            reservas = listarReservasPorPeriodoCase.execute(inicio, fim);
        } else if (checkin != null) {
            reservas = listarReservasPorCheckinCase.execute(checkin);
        } else {
            reservas = listarReservasCase.execute();
        }

        List<ReservaResponse> response = reservas.stream()
                .map(reserva -> {
                    Cachorro cachorro = buscarCachorroPorIdCase.execute(reserva.idCachorro());
                    return ReservaMapper.toResponse(reserva, CachorroMapper.toResumoResponse(cachorro));
                }).toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponse> buscarReservaPorId(@PathVariable Long id) {
        Reserva reserva = buscarReservaPorIdCase.execute(id);
        Cachorro cachorro = buscarCachorroPorIdCase.execute(reserva.idCachorro());
        CachorroResumoResponse cachorroResumoResponse = CachorroMapper.toResumoResponse(cachorro);
        return ResponseEntity.ok(ReservaMapper.toResponse(reserva, cachorroResumoResponse));
    }

    @PostMapping
    public ResponseEntity<ReservaResponse> criarReserva(@Valid @RequestBody CriarReservaRequest dto) {
        Reserva reserva = criarReservaCase.execute(ReservaMapper.toDomain(dto));
        Cachorro cachorro = buscarCachorroPorIdCase.execute(dto.idCachorro());
        CachorroResumoResponse cachorroResumoResponse = CachorroMapper.toResumoResponse(cachorro);
        ReservaResponse reservaResponse = ReservaMapper.toResponse(reserva, cachorroResumoResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(reservaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id) {
        deletarReservaPorIdCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/confirmar")
    public ResponseEntity<ReservaResponse> confirmarReserva(@PathVariable Long id) {
        Reserva reservaConfirmada = confirmarReservaCase.execute(id);
        Cachorro cachorro = buscarCachorroPorIdCase.execute(reservaConfirmada.idCachorro());

        return ResponseEntity.ok(
                ReservaMapper.toResponse(
                        reservaConfirmada,
                        CachorroMapper.toResumoResponse(cachorro)
                ));
    }

    @PatchMapping("/{id}/iniciar")
    public ResponseEntity<ReservaResponse> iniciarReserva(@PathVariable Long id) {
        Reserva reservaIniciada = iniciarReservaCase.execute(id);
        Cachorro cachorro = buscarCachorroPorIdCase.execute(reservaIniciada.idCachorro());

        return ResponseEntity.ok(
                ReservaMapper.toResponse(
                        reservaIniciada,
                        CachorroMapper.toResumoResponse(cachorro)
                ));
    }

    @PatchMapping("/{id}/finalizar")
    public ResponseEntity<ReservaResponse> finalizarReserva(@PathVariable Long id) {
        Reserva reservaFinalizada = finalizarReservaCase.execute(id);
        Cachorro cachorro = buscarCachorroPorIdCase.execute(reservaFinalizada.idCachorro());

        return ResponseEntity.ok(
                ReservaMapper.toResponse(
                        reservaFinalizada,
                        CachorroMapper.toResumoResponse(cachorro)
                ));
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<ReservaResponse> cancelarReserva(@PathVariable Long id) {
        Reserva reservaCancelada = cancelarReservaCase.execute(id);
        Cachorro cachorro = buscarCachorroPorIdCase.execute(reservaCancelada.idCachorro());

        return ResponseEntity.ok(
                ReservaMapper.toResponse(
                        reservaCancelada,
                        CachorroMapper.toResumoResponse(cachorro)
                ));
    }

}
