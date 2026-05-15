package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.usecases.cachorro.ListarCachorrosPorTutorCase;
import com.GabrielTiziano.AuAuPI.core.usecases.reserva.ListarReservasPorTutorCase;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.*;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarTutorRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.*;
import com.GabrielTiziano.AuAuPI.infra.mapper.CachorroMapper;
import com.GabrielTiziano.AuAuPI.infra.mapper.ReservaMapper;
import com.GabrielTiziano.AuAuPI.infra.mapper.TutorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
@Validated
public class TutorController {
    private final ListarTutoresCase listarTutoresCase;
    private final BuscarTutorPorIdCase buscarTutorPorIdCase;
    private final CriarTutorCase criarTutorCase;
    private final AtualizarTutorPorIdCase atualizarTutorPorIdCase;
    private final DeletarTutorPorIdCase deletarTutorPorIdCase;
    private final BuscarTutorPorCpfCase buscarTutorPorCpfCase;
    private final ListarCachorrosPorTutorCase listarCachorrosPorTutorCase;
    private final BuscarTutorPorNomeCase buscarTutorPorNomeCase;
    private final ListarReservasPorTutorCase listarReservasPorTutorCase;

    @GetMapping
    public ResponseEntity<List<TutorResponse>> listarTutores(
            @RequestParam(required = false) String nome
    ) {
        List<Tutor> tutores = (nome != null && !nome.isBlank())
                ? buscarTutorPorNomeCase.execute(nome)
                : listarTutoresCase.execute();

        return ResponseEntity.ok(tutores.stream().map(TutorMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorResponse> buscarTutorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(TutorMapper.toResponse(buscarTutorPorIdCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<TutorResponse> criarTutor(@Valid @RequestBody CriarTutorRequest dto) {
        Tutor tutorCriado = criarTutorCase.execute(TutorMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(TutorMapper.toResponse(tutorCriado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponse> atualizarTutor(@PathVariable Long id, @Valid @RequestBody CriarTutorRequest dto) {
        Tutor tutorAtualizado = atualizarTutorPorIdCase.execute(id, TutorMapper.toDomain(dto));
        return ResponseEntity.ok(TutorMapper.toResponse(tutorAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTutor(@PathVariable Long id) {
        deletarTutorPorIdCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<TutorResponse> buscarTutorPorCpf(
            @PathVariable
            @CPF(message = "CPF inválido.")
            String cpf) {
        return ResponseEntity.ok(TutorMapper.toResponse(buscarTutorPorCpfCase.execute(cpf)));
    }

    @GetMapping("/{id}/cachorros")
    public ResponseEntity<List<CachorroResponse>> listarCachorrosDeUmTutor(@PathVariable Long id){
        List<Cachorro> cachorroList = listarCachorrosPorTutorCase.execute(id);

        Tutor tutor = buscarTutorPorIdCase.execute(id);
        TutorResumoResponse tutorResumo = TutorMapper.toResumoResponse(tutor);

        List<CachorroResponse> response = cachorroList.stream()
                .map(cachorro -> CachorroMapper.toResponse(cachorro, tutorResumo))
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/reservas")
    public ResponseEntity<List<ReservaResponse>> listarReservasDoTutor(@PathVariable Long id) {
        List<Reserva> reservas = listarReservasPorTutorCase.execute(id);

        Map<Long, CachorroResumoResponse> cachorrosPorId = listarCachorrosPorTutorCase.execute(id)
                .stream()
                .collect(Collectors.toMap(
                        Cachorro::id,
                        CachorroMapper::toResumoResponse
                ));

        List<ReservaResponse> response = reservas.stream()
                .map(reserva -> ReservaMapper.toResponse(
                        reserva,
                        cachorrosPorId.get(reserva.idCachorro())
                ))
                .toList();

        return ResponseEntity.ok(response);
    }
}
