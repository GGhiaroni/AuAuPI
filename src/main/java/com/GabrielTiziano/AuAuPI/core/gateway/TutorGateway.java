package com.GabrielTiziano.AuAuPI.core.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;

import java.util.List;
import java.util.Optional;

public interface TutorGateway {
    Tutor save(Tutor tutor);
    Optional<Tutor> findById(Long id);
    List<Tutor> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
    boolean existsByCpf(String cpf);
    Optional<Tutor> findByCpf(String cpf);
    List<Tutor> findByNomeParcial(String nome);
}
