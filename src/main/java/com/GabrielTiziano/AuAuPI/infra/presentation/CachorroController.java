package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.*;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.BuscarTutorPorIdCase;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarCachorroRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.TutorResumoResponse;
import com.GabrielTiziano.AuAuPI.infra.mapper.CachorroMapper;
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

    @GetMapping("/{id}")
    public ResponseEntity<CachorroResponse> buscarCachorroPorId(@PathVariable Long id) {
        Cachorro cachorro = buscarCachorroPorIdCase.execute(id);
        Tutor tutor = buscarTutorPorIdCase.execute(cachorro.idTutor());
        TutorResumoResponse tutorResumoResponse = new TutorResumoResponse(tutor.id(), tutor.nome(), tutor.telefone());

        return ResponseEntity.ok(CachorroMapper.toResponse(cachorro, tutorResumoResponse));
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
        Tutor tutor = buscarTutorPorIdCase.execute(dto.idTutor());
        TutorResumoResponse tutorResumoResponse = TutorMapper.toResumoResponse(tutor);
        Cachorro cachorroAtualizado = atualizarCachorroCase.execute(id, CachorroMapper.toDomain(dto));
        return ResponseEntity.ok(CachorroMapper.toResponse(cachorroAtualizado, tutorResumoResponse));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCachorro(@PathVariable Long id) {
        deletarCachorroCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
