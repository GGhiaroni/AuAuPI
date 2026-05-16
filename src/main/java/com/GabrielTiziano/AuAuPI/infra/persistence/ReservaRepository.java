package com.GabrielTiziano.AuAuPI.infra.persistence;

import com.GabrielTiziano.AuAuPI.core.entities.CachorroFrequente;
import com.GabrielTiziano.AuAuPI.core.entities.TutorFrequente;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByCachorroId(Long id);
    List<ReservaEntity> findByStatus(StatusReserva status);
    @Query("""
    SELECT r FROM ReservaEntity r
    WHERE r.dataCheckin <= :fim
      AND r.dataCheckout >= :inicio
""")
    List<ReservaEntity> findByPeriodo(
            @Param("inicio") LocalDate inicio,
            @Param("fim") LocalDate fim
    );
    List<ReservaEntity> findByDataCheckin(LocalDate checkin);
    @Query("""
    SELECT r FROM ReservaEntity r
    WHERE r.cachorro.tutor.id = :idTutor
""")
    List<ReservaEntity> findByTutorId(@Param("idTutor") Long idTutor);
    @Query("""
    SELECT new com.GabrielTiziano.AuAuPI.core.entities.CachorroFrequente(
        c.id, c.nome, c.raca, c.porte, COUNT(r)
    )
    FROM ReservaEntity r
    JOIN r.cachorro c
    WHERE r.status IN (
        com.GabrielTiziano.AuAuPI.core.enums.StatusReserva.CONFIRMADA,
        com.GabrielTiziano.AuAuPI.core.enums.StatusReserva.EM_ANDAMENTO,
        com.GabrielTiziano.AuAuPI.core.enums.StatusReserva.FINALIZADA
    )
    GROUP BY c.id, c.nome, c.raca, c.porte
    ORDER BY COUNT(r) DESC
""")
    List<CachorroFrequente> findCachorrosFrequentes(Pageable pageable);
    @Query("""
    SELECT new com.GabrielTiziano.AuAuPI.core.entities.TutorFrequente(
        t.id, t.nome, t.telefone, COUNT(r)
    )
    FROM ReservaEntity r
    JOIN r.cachorro c
    JOIN c.tutor t
    WHERE r.status IN (
        com.GabrielTiziano.AuAuPI.core.enums.StatusReserva.CONFIRMADA,
        com.GabrielTiziano.AuAuPI.core.enums.StatusReserva.EM_ANDAMENTO,
        com.GabrielTiziano.AuAuPI.core.enums.StatusReserva.FINALIZADA
    )
    GROUP BY t.id, t.nome, t.telefone
    ORDER BY COUNT(r) DESC
""")
    List<TutorFrequente> findTutoresFrequentes(Pageable pageable);
    long countByStatus(StatusReserva status);
    long countByDataCheckinAndStatus(LocalDate dataCheckin, StatusReserva status);
    long countByDataCheckoutAndStatus(LocalDate dataCheckout, StatusReserva status);
}
