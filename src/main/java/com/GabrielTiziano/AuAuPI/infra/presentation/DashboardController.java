package com.GabrielTiziano.AuAuPI.infra.presentation;

import com.GabrielTiziano.AuAuPI.core.entities.DashboardHoje;
import com.GabrielTiziano.AuAuPI.core.usecases.dashboard.ObterDashboardHojeCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final ObterDashboardHojeCase obterDashboardHojeCase;

    @GetMapping("/hoje")
    public ResponseEntity<DashboardHoje> hoje() {
        return ResponseEntity.ok(obterDashboardHojeCase.execute());
    }
}