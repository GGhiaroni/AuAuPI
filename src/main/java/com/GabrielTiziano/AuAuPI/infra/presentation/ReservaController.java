package com.GabrielTiziano.AuAuPI.infra.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @PostMapping
    public String criarReserva(){
        return "Reserva criada.";
    }
}
