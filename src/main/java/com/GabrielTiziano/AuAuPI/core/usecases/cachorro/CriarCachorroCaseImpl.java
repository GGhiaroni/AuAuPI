package com.GabrielTiziano.AuAuPI.core.usecases.cachorro;

import com.GabrielTiziano.AuAuPI.core.entities.Cachorro;
import com.GabrielTiziano.AuAuPI.core.gateway.CachorroGateway;
import com.GabrielTiziano.AuAuPI.core.gateway.TutorGateway;

public class CriarCachorroCaseImpl implements CriarCachorroCase{
    private final CachorroGateway cachorroGateway;
    private final TutorGateway tutorGateway;

    public CriarCachorroCaseImpl(CachorroGateway cachorroGateway, TutorGateway tutorGateway) {
        this.cachorroGateway = cachorroGateway;
        this.tutorGateway = tutorGateway;
    }

    @Override
    public Cachorro execute(Cachorro cachorro) {
        if(!tutorGateway.existsById(cachorro.idTutor())){
            throw new IllegalArgumentException(
                    "Tutor não encontrado: " + cachorro.idTutor()
            );
        }

        Cachorro cachorroASalvar = new Cachorro(
                null,
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
