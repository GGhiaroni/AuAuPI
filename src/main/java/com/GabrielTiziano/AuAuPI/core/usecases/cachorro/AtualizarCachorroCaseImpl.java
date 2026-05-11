package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

public class AtualizarCachorroCaseImpl implements AtualizarCachorroCase{
    private final CachorroGateway cachorroGateway;
    private final TutorGateway tutorGateway;

    public AtualizarCachorroCaseImpl(CachorroGateway cachorroGateway, TutorGateway tutorGateway) {
        this.cachorroGateway = cachorroGateway;
        this.tutorGateway = tutorGateway;
    }

    @Override
    public Cachorro execute(Long id, Cachorro cachorro) {
        if(!cachorroGateway.existsById(id)) {
            throw new IllegalArgumentException("Não foi possível localizar um cachorro de id " + id + ".");
        }

        if (!tutorGateway.existsById(cachorro.idTutor())) {
            throw new IllegalArgumentException("Tutor de id " + cachorro.idTutor() + " não encontrado.");
        }

        Cachorro cachorroASalvar = new Cachorro(
                id,
                cachorro.nome(),
                cachorro.raca(),
                cachorro.porte(),
                cachorro.peso(),
                cachorro.dataNascimento(),
                cachorro.sexo(),
                cachorro.castrado(),
                cachorro.observacoesMedicas(),
                cachorro.idTutor()
        );

        return cachorroGateway.save(cachorroASalvar);
    }
}
