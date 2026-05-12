package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.*;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.ListarReservasPorCachorroIdCase;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.BuscarTutorPorIdCase;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarCachorroRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResumoResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.ReservaResponse;
import com.GabrielTiziano.AuAuPI.infra.mapper.CachorroMapper;
import com.GabrielTiziano.AuAuPI.infra.mapper.ReservaMapper;
import com.GabrielTiziano.AuAuPI.infra.mapper.TutorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cachorros")
@RequiredArgsConstructor
public class CachorroController {
    private final CriarCachorroCase criarCachorroCase;
    private final BuscarTutorPorIdCase buscarTutorPorIdCase;
    private final ListarCachorrosCase listarCachorrosCase;
    private final BuscarCachorroPorIdCase buscarCachorroPorIdCase;
    private final DeletarCachorroCase deletarCachorroCase;
    private final AtualizarCachorroCase atualizarCachorroCase;
    private final ListarCachorrosPorPorteCase listarCachorrosPorPorteCase;
    private final ListarCachorrosPorNomeCase listarCachorrosPorNomeCase;
    private final ListarCachorrosPorRacaCase listarCachorrosPorRacaCase;
    private final ListarCachorrosPorSexoCase listarCachorrosPorSexoCase;
    private final ListarReservasPorCachorroIdCase listarReservasPorCachorroId;

    @GetMapping
    public ResponseEntity<List<CachorroResponse>> listarCachorros(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Porte porte,
            @RequestParam(required = false) String raca,
            @RequestParam(required = false) Sexo sexo
    ) {
        List<Cachorro> cachorros;

        if (porte != null) {
            cachorros = listarCachorrosPorPorteCase.execute(porte);
        } else if (nome != null && !nome.isBlank()) {
            cachorros = listarCachorrosPorNomeCase.execute(nome);
        } else if (raca != null && !raca.isBlank()) {
            cachorros = listarCachorrosPorRacaCase.execute(raca);
        } else if (sexo != null) {
            cachorros = listarCachorrosPorSexoCase.execute(sexo);
        } else {
            cachorros = listarCachorrosCase.execute();
        }

        List<CachorroResponse> response = cachorros.stream()
                .map(cachorro -> CachorroMapper.toResponse(
                        cachorro,
                        TutorMapper.toResumoResponse(buscarTutorPorIdCase.execute(cachorro.idTutor()))
                ))
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CachorroResponse> buscarCachorroPorId(@PathVariable Long id) {
        Cachorro cachorro = buscarCachorroPorIdCase.execute(id);
        Tutor tutor = buscarTutorPorIdCase.execute(cachorro.idTutor());

        return ResponseEntity.ok(
                CachorroMapper.toResponse(cachorro, TutorMapper.toResumoResponse(tutor))
        );
    }

    @GetMapping("/{id}/reservas")
    public ResponseEntity<List<ReservaResponse>> listarReservasPorCachorro(@PathVariable Long id){
        List<Reserva> reservaList = listarReservasPorCachorroId.execute(id);
        Cachorro cachorro =  buscarCachorroPorIdCase.execute(id);
        CachorroResumoResponse cachorroResumoResponse = CachorroMapper.toResumoResponse(cachorro);

        List<ReservaResponse> reservaResponses =
                reservaList.stream()
                        .map(reserva -> ReservaMapper.toResponse(reserva, cachorroResumoResponse))
                        .toList();

        return ResponseEntity.ok(reservaResponses);
    }

    @PostMapping
    public ResponseEntity<CachorroResponse> criarCachorro(@Valid @RequestBody CriarCachorroRequest dto) {
        Cachorro cachorroCriado = criarCachorroCase.execute(CachorroMapper.toDomain(dto));
        Tutor tutor = buscarTutorPorIdCase.execute(cachorroCriado.idTutor());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CachorroMapper
                        .toResponse(cachorroCriado, TutorMapper.toResumoResponse(tutor)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CachorroResponse> atualizarCachorro(@PathVariable Long id, @Valid @RequestBody CriarCachorroRequest dto) {
        Cachorro cachorroAtualizado = atualizarCachorroCase.execute(id, CachorroMapper.toDomain(dto));
        Tutor tutor = buscarTutorPorIdCase.execute(cachorroAtualizado.idTutor());
        return ResponseEntity.ok(
                CachorroMapper.toResponse(cachorroAtualizado, TutorMapper.toResumoResponse(tutor))
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCachorro(@PathVariable Long id) {
        deletarCachorroCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
