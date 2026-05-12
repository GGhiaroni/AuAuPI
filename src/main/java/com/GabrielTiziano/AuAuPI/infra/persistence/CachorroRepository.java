package com.GabrielTiziano.AuAuPI.infra.persistence;

import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CachorroRepository extends JpaRepository<CachorroEntity, Long> {
    List<CachorroEntity> findByTutorId(Long id);
    List<CachorroEntity> findByPorte(Porte porte);
    List<CachorroEntity> findBySexo(Sexo sexo);
    List<CachorroEntity> findByNomeContainingIgnoreCase(String nome);
    List<CachorroEntity> findByRacaContainingIgnoreCase(String raca);
}
