package com.GabrielTiziano.AuAuPI.infra.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cachorro")
public class CachorroController {
    @PostMapping
    public String criarCachorro(){
        return "Cachorro criado.";
    }
}
