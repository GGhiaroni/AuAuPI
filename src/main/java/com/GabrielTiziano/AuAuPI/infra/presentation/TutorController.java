package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.*;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarTutorRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.TutorResponse;
import com.GabrielTiziano.AuAuPI.infra.mapper.TutorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
public class TutorController {
    private final ListarTutoresCase listarTutoresCase;
    private final BuscarTutorPorIdCase buscarTutorPorIdCase;
    private final CriarTutorCase criarTutorCase;
    private final AtualizarTutorPorIdCase atualizarTutorPorIdCase;
    private final DeletarTutorPorIdCase deletarTutorPorIdCase;

    @GetMapping
    public ResponseEntity<List<TutorResponse>> listarTutores() {
        List<Tutor> tutorList = listarTutoresCase.execute();
        List<TutorResponse> tutorResponseList = tutorList.stream()
                .map(TutorMapper::toResponse)
                .toList();

        return ResponseEntity.ok(tutorResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorResponse> buscarTutorPorId(@PathVariable Long id){
        return ResponseEntity.ok(TutorMapper.toResponse(buscarTutorPorIdCase.execute(id)));
    }

    @PostMapping
    public ResponseEntity<TutorResponse> criarTutor(@Valid @RequestBody CriarTutorRequest dto) {
        Tutor tutorCriado = criarTutorCase.execute(TutorMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(TutorMapper.toResponse(tutorCriado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponse> atualizarTutor(@PathVariable Long id, @Valid @RequestBody CriarTutorRequest dto){
        Tutor tutorAtualizado = atualizarTutorPorIdCase.execute(id, TutorMapper.toDomain(dto));
        return ResponseEntity.ok(TutorMapper.toResponse(tutorAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTutor(@PathVariable Long id) {
        deletarTutorPorIdCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
