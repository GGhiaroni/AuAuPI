package com.GabrielTiziano.AuAuPI.infra.mapper;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.entities.Reserva;
import com.GabrielTiziano.AuAuPI.core.enums.StatusReserva;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarReservaRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResumoResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.ReservaResponse;
import com.GabrielTiziano.AuAuPI.infra.persistence.CachorroEntity;
import com.GabrielTiziano.AuAuPI.infra.persistence.ReservaEntity;

public class ReservaMapper {
    public static Reserva toDomain(CriarReservaRequest dto){
        return new Reserva(
                null,
                dto.idCachorro(),
                dto.dataCheckin(),
                dto.dataCheckout(),
                null,
                dto.valorDiaria(),
                dto.observacoes()
        );
    }

    public static Reserva toDomain(ReservaEntity reservaEntity){
        return new Reserva(
                reservaEntity.getId(),
                reservaEntity.getCachorro().getId(),
                reservaEntity.getDataCheckin(),
                reservaEntity.getDataCheckout(),
                reservaEntity.getStatus(),
                reservaEntity.getValorDiaria(),
                reservaEntity.getObservacoes()
        );
    }

    public static ReservaResponse toResponse(Reserva domain, CachorroResumoResponse cachorro){
        return new ReservaResponse(
                domain.id(),
                cachorro,
                domain.dataCheckin(),
                domain.dataCheckout(),
                domain.status(),
                domain.valorDiaria(),
                domain.calcularQuantidadeDiarias(),
                domain.calcularValorTotal(),
                domain.observacoes()
        );

    }

    public static ReservaEntity toEntity(Reserva domain, CachorroEntity cachorro){
        return ReservaEntity.builder()
                .id(domain.id())
                .cachorro(cachorro)
                .dataCheckin(domain.dataCheckin())
                .dataCheckout(domain.dataCheckout())
                .status(domain.status())
                .valorDiaria(domain.valorDiaria())
                .observacoes(domain.observacoes())
                .build();
    }
}
