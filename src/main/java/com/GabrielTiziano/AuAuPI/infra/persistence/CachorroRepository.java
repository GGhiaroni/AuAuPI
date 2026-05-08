package com.GabrielTiziano.AuAuPI.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CachorroRepository extends JpaRepository<CachorroEntity, Long> {
    List<CachorroEntity> findByTutorId(Long id);
}
