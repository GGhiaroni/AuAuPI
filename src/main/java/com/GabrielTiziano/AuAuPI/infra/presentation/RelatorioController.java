package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.CachorroFrequente;
import com.GabrielTiziano.AuAuPI.core.entities.TutorFrequente;
import com.GabrielTiziano.AuAuPI.core.usecases.relatorio.ListarCachorrosFrequentesCase;
import com.GabrielTiziano.AuAuPI.core.usecases.relatorio.ListarTutoresFrequentesCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatorioController {

    private final ListarCachorrosFrequentesCase listarCachorrosFrequentesCase;
    private final ListarTutoresFrequentesCase listarTutoresFrequentesCase;

    @GetMapping("/cachorros-frequentes")
    public ResponseEntity<List<CachorroFrequente>> cachorrosFrequentes(
            @RequestParam(defaultValue = "10") int limite) {
        return ResponseEntity.ok(listarCachorrosFrequentesCase.execute(limite));
    }

    @GetMapping("/tutores-frequentes")
    public ResponseEntity<List<TutorFrequente>> tutoresFrequentes(
            @RequestParam(defaultValue = "10") int limite) {
        return ResponseEntity.ok(listarTutoresFrequentesCase.execute(limite));
    }
}
