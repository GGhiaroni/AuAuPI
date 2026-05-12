package com.GabrielTiziano.AuAuPI.infra.persistence;

import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
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
}
