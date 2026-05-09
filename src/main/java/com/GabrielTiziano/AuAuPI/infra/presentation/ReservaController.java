package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.BuscarCachorroPorIdCase;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.CriarReservaCase;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarReservaRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResumoResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.ReservaResponse;
import com.GabrielTiziano.AuAuPI.infra.mapper.CachorroMapper;
import com.GabrielTiziano.AuAuPI.infra.mapper.ReservaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {
    private final CriarReservaCase criarReservaCase;
    private final BuscarCachorroPorIdCase buscarCachorroPorIdCase;
    @PostMapping
    public ResponseEntity<ReservaResponse> criarReserva(@Valid @RequestBody CriarReservaRequest dto){
        Reserva reserva = criarReservaCase.execute(ReservaMapper.toDomain(dto));
        Cachorro cachorro = buscarCachorroPorIdCase.execute(dto.idCachorro());
        CachorroResumoResponse cachorroResumoResponse = CachorroMapper.toResumoResponse(cachorro);
        ReservaResponse reservaResponse = ReservaMapper.toResponse(reserva, cachorroResumoResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(reservaResponse);
    }
}
