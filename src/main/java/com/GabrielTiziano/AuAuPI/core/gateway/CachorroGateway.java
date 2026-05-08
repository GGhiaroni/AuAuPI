package com.GabrielTiziano.AuAuPI.core.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;

import java.util.List;
import java.util.Optional;

public interface CachorroGateway {
    Cachorro save(Cachorro cachorro);
    Optional<Cachorro> findById(Long id);
    List<Cachorro> findAll();
    List<Cachorro> findByTutorId(Long idTutor);
    void deleteById(Long id);
    boolean existsById(Long id);
}
