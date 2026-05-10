package com.GabrielTiziano.AuAuPI.infra.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Tutor;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;
import com.GabrielTiziano.AuAuPI.infra.mapper.TutorMapper;
import com.GabrielTiziano.AuAuPI.infra.persistence.TutorEntity;
import com.GabrielTiziano.AuAuPI.infra.persistence.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TutorRepositoryGateway implements TutorGateway {
    private final TutorRepository tutorRepository;

    @Override
    public Tutor save(Tutor tutor) {
       TutorEntity entitySalva = tutorRepository.save(TutorMapper.toEntity(tutor));
       return TutorMapper.toDomain(entitySalva);
    }

    @Override
    public Optional<Tutor> findById(Long id) {
        return tutorRepository.findById(id)
                .map(TutorMapper::toDomain);
    }

    @Override
    public List<Tutor> findAll() {
        return tutorRepository.findAll()
                .stream().map(TutorMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        tutorRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return tutorRepository.existsById(id);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return tutorRepository.existsByCpf(cpf);
    }
}
