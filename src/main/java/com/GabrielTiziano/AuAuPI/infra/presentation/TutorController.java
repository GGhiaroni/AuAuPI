package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.usecases.tutor.CriarTutorCase;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarTutorRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.TutorResponse;
import com.GabrielTiziano.AuAuPI.infra.mapper.TutorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutores")
@RequiredArgsConstructor
public class TutorController {
    private final CriarTutorCase criarTutorCase;
    @PostMapping
    public ResponseEntity<TutorResponse> criarTutor(@Valid @RequestBody CriarTutorRequest dto){
        Tutor tutorCriado = criarTutorCase.execute(TutorMapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(TutorMapper.toResponse(tutorCriado));
    }
}
