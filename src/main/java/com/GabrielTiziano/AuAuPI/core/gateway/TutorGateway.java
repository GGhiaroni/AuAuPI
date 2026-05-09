package com.GabrielTiziano.AuAuPI.core.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;

import java.util.List;

public interface TutorGateway {
    Tutor save(Tutor tutor);
    boolean findById(Long id);
    List<Tutor> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
    boolean existsByCpf(String cpf);
}
