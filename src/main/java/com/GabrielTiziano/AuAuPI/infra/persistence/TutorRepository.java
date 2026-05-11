package com.GabrielTiziano.AuAuPI.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
    boolean existsByCpf(String cpf);
    Optional<TutorEntity> findByCpf(String cpf);
    List<TutorEntity> findByNomeContainingIgnoreCase(String nome);
}
