package com.GabrielTiziano.AuAuPI.core.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.enums.Porte;

import java.util.List;
import java.util.Optional;

public interface CachorroGateway {
    Cachorro save(Cachorro cachorro);
    Optional<Cachorro> findById(Long id);
    List<Cachorro> findAll();
    List<Cachorro> findByTutorId(Long idTutor);
    void deleteById(Long id);
    boolean existsById(Long id);
    List<Cachorro> findByPorte(Porte porte);
}
