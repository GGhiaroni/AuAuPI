package com.GabrielTiziano.AuAuPI.infra.mapper;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarTutorRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.TutorResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.TutorResumoResponse;
import com.GabrielTiziano.AuAuPI.infra.persistence.TutorEntity;

public class TutorMapper {
    public static Tutor toDomain(CriarTutorRequest dto) {
        return new Tutor(
                null,
                dto.nome(),
                dto.cpf(),
                dto.email(),
                dto.endereco(),
                dto.telefone(),
                null
        );
    }

    public static Tutor toDomain(TutorEntity entity){
        return new Tutor(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getEndereco(),
                entity.getTelefone(),
                entity.getCreatedAt()
        );
    }

    public static TutorResponse toResponse(Tutor domain){
        return new TutorResponse(
                domain.id(),
                domain.nome(),
                domain.cpf(),
                domain.email(),
                domain.endereco(),
                domain.telefone(),
                domain.createdAt()
        );
    }

    public static TutorEntity toEntity(Tutor domain){
        return TutorEntity.builder()
                .id(domain.id())
                .nome(domain.nome())
                .cpf(domain.cpf())
                .email(domain.email())
                .telefone(domain.telefone())
                .endereco(domain.endereco())
                .createdAt(domain.createdAt())
                .build();

    }

    public static TutorResumoResponse toResumoResponse(Tutor domain) {
        return new TutorResumoResponse(
                domain.id(),
                domain.nome(),
                domain.telefone()
        );
    }
}
