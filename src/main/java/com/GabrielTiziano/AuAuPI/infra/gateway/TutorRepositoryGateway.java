package com.GabrielTiziano.AuAuPI.infra.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

import java.util.List;
import java.util.Optional;

public class TutorRepositoryGateway implements TutorGateway {
    @Override
    public Tutor save(Tutor tutor) {
        return null;
    }

    @Override
    public Optional<Tutor> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Tutor> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return false;
    }
}
