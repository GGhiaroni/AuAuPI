package com.GabrielTiziano.AuAuPI.infra.gateway;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.enums.Porte;
import com.GabrielTiziano.AuAuPI.core.enums.Sexo;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.infra.mapper.CachorroMapper;
import com.GabrielTiziano.AuAuPI.infra.persistence.CachorroEntity;
import com.GabrielTiziano.AuAuPI.infra.persistence.CachorroRepository;
import com.GabrielTiziano.AuAuPI.infra.persistence.TutorEntity;
import com.GabrielTiziano.AuAuPI.infra.persistence.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CachorroRepositoryGateway implements CachorroGateway {
    private final CachorroRepository cachorroRepository;
    private final TutorRepository tutorRepository;

    @Override
    public Cachorro save(Cachorro cachorro) {
        TutorEntity tutorEntity = tutorRepository.findById(cachorro.idTutor())
                .orElseThrow(() -> new IllegalStateException(
                        "Tutor inexistente ao salvar cachorro: " + cachorro.idTutor()
                ));
        return CachorroMapper.toDomain(cachorroRepository.save(CachorroMapper.toEntity(cachorro, tutorEntity)));
    }

    @Override
    public Optional<Cachorro> findById(Long id) {
        return cachorroRepository.findById(id)
                .map(CachorroMapper::toDomain);
    }

    @Override
    public List<Cachorro> findAll() {
        return cachorroRepository.findAll()
                .stream()
                .map(CachorroMapper::toDomain)
                .toList();
    }

    @Override
    public List<Cachorro> findByTutorId(Long idTutor) {
        return cachorroRepository.findByTutorId(idTutor)
                .stream()
                .map(CachorroMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        cachorroRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return cachorroRepository.existsById(id);
    }

    @Override
    public List<Cachorro> findByPorte(Porte porte) {
        List<CachorroEntity> cachorroEntityList = cachorroRepository.findByPorte(porte);
        return cachorroEntityList.stream()
                .map(CachorroMapper::toDomain)
                .toList();
    }

    @Override
    public List<Cachorro> findBySexo(Sexo sexo) {
        return cachorroRepository.findBySexo(sexo)
                .stream()
                .map(CachorroMapper::toDomain)
                .toList();
    }

    @Override
    public List<Cachorro> findByRaca(String raca) {
        return cachorroRepository.findByRacaContainingIgnoreCase(raca)
                .stream()
                .map(CachorroMapper::toDomain)
                .toList();
    }

    @Override
    public List<Cachorro> findByNome(String nome) {
        return cachorroRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(CachorroMapper::toDomain)
                .toList();
    }

}
