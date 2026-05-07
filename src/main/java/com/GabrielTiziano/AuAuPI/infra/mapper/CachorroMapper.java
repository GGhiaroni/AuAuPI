package com.GabrielTiziano.AuAuPI.infra.mapper;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.infra.dto.request.CriarCachorroRequest;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.CachorroResumoResponse;
import com.GabrielTiziano.AuAuPI.infra.dto.response.TutorResumoResponse;
import com.GabrielTiziano.AuAuPI.infra.persistence.CachorroEntity;
import com.GabrielTiziano.AuAuPI.infra.persistence.TutorEntity;

public class CachorroMapper {
    public static Cachorro toDomain(CriarCachorroRequest dto) {
        return new Cachorro(
                null,
                dto.nome(),
                dto.raca(),
                dto.porte(),
                dto.peso(),
                dto.dataNascimento(),
                dto.sexo(),
                dto.castrado(),
                dto.observacoesMedicas(),
                dto.idTutor()
        );
    }

    public static Cachorro toDomain(CachorroEntity entity) {
        return new Cachorro(
                entity.getId(),
                entity.getNome(),
                entity.getRaca(),
                entity.getPorte(),
                entity.getPeso(),
                entity.getDataNascimento(),
                entity.getSexo(),
                entity.isCastrado(),
                entity.getObservacoesMedicas(),
                entity.getTutor().getId()
        );
    }

    public static CachorroResponse toResponse(Cachorro domain, TutorResumoResponse tutor) {
        return new CachorroResponse(
                domain.id(),
                domain.nome(),
                domain.raca(),
                domain.porte(),
                domain.peso(),
                domain.calcularIdadeEmAnos(),
                domain.sexo(),
                domain.castrado(),
                domain.observacoesMedicas(),
                tutor
        );
    }

    public static CachorroEntity toEntity(Cachorro domain, TutorEntity tutor) {
        return CachorroEntity.builder()
                .id(domain.id())
                .nome(domain.nome())
                .raca(domain.raca())
                .porte(domain.porte())
                .peso(domain.peso())
                .dataNascimento(domain.dataNascimento())
                .sexo(domain.sexo())
                .castrado(domain.castrado())
                .observacoesMedicas(domain.observacoesMedicas())
                .tutor(tutor)
                .build();
    }

    public static CachorroResumoResponse toResumoResponse(Cachorro cachorro){
        return new CachorroResumoResponse(
                cachorro.id(),
                cachorro.nome(),
                cachorro.raca(),
                cachorro.porte(),
                cachorro.peso()
        );
    }
}
