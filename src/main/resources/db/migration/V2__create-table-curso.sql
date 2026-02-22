create table curso (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
)