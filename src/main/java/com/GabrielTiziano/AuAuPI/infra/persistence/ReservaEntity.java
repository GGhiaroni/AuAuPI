package com.GabrielTiziano.AuAuPI.infra.persistence;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "reserva")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "dataCheckin", "dataCheckout", "status"})
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cachorro", nullable = false)
    private Cachorro cachorro;

    @Column(name = "data_checkin", nullable = false)
    private LocalDate dataCheckin;

    @Column(name = "data_checkout", nullable = false)
    private LocalDate dataCheckout;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusReserva status;

    @Column(name = "valor_diaria", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDiaria;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public long calcularQuantidadeDiarias() {
        return ChronoUnit.DAYS.between(dataCheckin, dataCheckout);
    }

    public BigDecimal calcularValorTotal() {
        return valorDiaria.multiply(BigDecimal.valueOf(calcularQuantidadeDiarias()));
    }
}
