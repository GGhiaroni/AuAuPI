CREATE TABLE tutor
(
    id         BIGSERIAL PRIMARY KEY,
    nome       VARCHAR(120) NOT NULL,
    cpf        VARCHAR(14)  NOT NULL,
    email      VARCHAR(150) NOT NULL,
    telefone   VARCHAR(20)  NOT NULL,
    endereco   VARCHAR(200) NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    CONSTRAINT uq_tutor_cpf UNIQUE (cpf),
    CONSTRAINT uq_tutor_email UNIQUE (email)
);

CREATE TABLE cachorro
(
    id                  BIGSERIAL PRIMARY KEY,
    nome                VARCHAR(80)      NOT NULL,
    raca                VARCHAR(80)      NOT NULL,
    porte               VARCHAR(20)      NOT NULL,
    peso                DOUBLE PRECISION NOT NULL,
    data_nascimento     DATE             NOT NULL,
    sexo                VARCHAR(10)      NOT NULL,
    castrado            BOOLEAN          NOT NULL,
    observacoes_medicas TEXT,
    id_tutor            BIGINT           NOT NULL,
    CONSTRAINT fk_cachorro_tutor
        FOREIGN KEY (id_tutor) REFERENCES tutor (id) ON DELETE RESTRICT,
    CONSTRAINT ck_cachorro_porte
        CHECK (porte IN ('PEQUENO', 'MEDIO', 'GRANDE', 'GIGANTE')),
    CONSTRAINT ck_cachorro_sexo
        CHECK (sexo IN ('MACHO', 'FEMEA')),
    CONSTRAINT ck_cachorro_peso
        CHECK (peso > 0)
);

CREATE INDEX ix_cachorro_id_tutor ON cachorro (id_tutor);

CREATE TABLE reserva
(
    id            BIGSERIAL PRIMARY KEY,
    id_cachorro   BIGINT         NOT NULL,
    data_checkin  DATE           NOT NULL,
    data_checkout DATE           NOT NULL,
    status        VARCHAR(20)    NOT NULL,
    valor_diaria  NUMERIC(10, 2) NOT NULL,
    observacoes   TEXT,
    CONSTRAINT fk_reserva_cachorro
        FOREIGN KEY (id_cachorro) REFERENCES cachorro (id) ON DELETE RESTRICT,
    CONSTRAINT ck_reserva_status
        CHECK (status IN ('PENDENTE', 'CONFIRMADA', 'EM_ANDAMENTO', 'FINALIZADA', 'CANCELADA')),
    CONSTRAINT ck_reserva_datas
        CHECK (data_checkout > data_checkin),
    CONSTRAINT ck_reserva_valor
        CHECK (valor_diaria > 0)
);

CREATE INDEX ix_reserva_id_cachorro ON reserva (id_cachorro);
CREATE INDEX ix_reserva_status ON reserva (status);