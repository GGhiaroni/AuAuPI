package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.CriarCachorroCase;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.ListarCachorrosCase;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.BuscarTutorPorIdCase;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarCachorroRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResponse;
import com.GabrielTiziano.AuAuPI.infra.mapper.CachorroMapper;
import com.GabrielTiziano.AuAuPI.infra.mapper.TutorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/cachorros")
@RequiredArgsConstructor
public class CachorroController {
    private final CriarCachorroCase criarCachorroCase;
    private final BuscarTutorPorIdCase buscarTutorPorIdCase;
    private final ListarCachorrosCase listarCachorrosCase;

    @GetMapping
    public ResponseEntity<List<CachorroResponse>> listarCachorros() {
        List<Cachorro> cachorroList = listarCachorrosCase.execute();

        List<CachorroResponse> cachorroResponseList = cachorroList.stream()
                .map(cachorro ->
                        CachorroMapper.toResponse(cachorro,
                                TutorMapper.toResumoResponse(buscarTutorPorIdCase.execute((cachorro.idTutor())))))
                .toList();

        return ResponseEntity.ok(cachorroResponseList);
    }

    @PostMapping
    public ResponseEntity<CachorroResponse> criarCachorro(@Valid @RequestBody CriarCachorroRequest dto) {
        Cachorro cachorroCriado = criarCachorroCase.execute(CachorroMapper.toDomain(dto));
        Tutor tutor = buscarTutorPorIdCase.execute(cachorroCriado.idTutor());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CachorroMapper
                        .toResponse(cachorroCriado, TutorMapper.toResumoResponse(tutor)));
    }
}
