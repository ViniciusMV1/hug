CREATE TABLE empresa
(
    cnpj     VARCHAR(255) NOT NULL,
    nome     VARCHAR(255) NULL,
    telefone VARCHAR(255) NULL,
    rua      VARCHAR(255) NULL,
    numero   VARCHAR(255) NULL,
    bairro   VARCHAR(255) NULL,
    cidade   VARCHAR(255) NULL,
    estado   VARCHAR(255) NULL,
    cep      VARCHAR(255) NULL,
    CONSTRAINT pk_empresa PRIMARY KEY (cnpj)
);

CREATE TABLE notas
(
    id    BIGINT NOT NULL,
    texto VARCHAR(255) NULL,
    CONSTRAINT pk_notas PRIMARY KEY (id)
);

CREATE TABLE pessoa
(
    cpf        VARCHAR(255) NOT NULL,
    dtype      VARCHAR(31) NULL,
    nome       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    telefone   VARCHAR(255) NULL,
    rua        VARCHAR(255) NULL,
    numero     VARCHAR(255) NULL,
    bairro     VARCHAR(255) NULL,
    cidade     VARCHAR(255) NULL,
    estado     VARCHAR(255) NULL,
    cep        VARCHAR(255) NULL,
    crp        VARCHAR(255) NULL,
    empresa_id VARCHAR(255) NULL,
    CONSTRAINT pk_pessoa PRIMARY KEY (cpf)
);

CREATE TABLE usuarios
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    login VARCHAR(255) NULL,
    senha VARCHAR(255) NULL,
    CONSTRAINT pk_usuarios PRIMARY KEY (id)
);

ALTER TABLE pessoa
    ADD CONSTRAINT FK_PESSOA_ON_EMPRESA FOREIGN KEY (empresa_id) REFERENCES empresa (cnpj);