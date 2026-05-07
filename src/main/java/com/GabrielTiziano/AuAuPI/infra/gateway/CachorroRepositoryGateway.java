package com.GabrielTiziano.AuAuPI.infra.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;

import java.util.List;
import java.util.Optional;

public class CachorroRepositoryGateway implements CachorroGateway {
    @Override
    public Cachorro save(Cachorro cachorro) {
        return null;
    }

    @Override
    public Optional<Cachorro> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Cachorro> findAll() {
        return List.of();
    }

    @Override
    public List<Cachorro> findByIdTutor(Long idTutor) {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
