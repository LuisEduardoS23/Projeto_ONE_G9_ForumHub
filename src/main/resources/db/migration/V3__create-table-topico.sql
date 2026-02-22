create table topicos (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    titulo VARCHAR(100) NOT NULL,
    mensagem VARCHAR(250) NOT NULL,
    status BOOLEAN NOT NULL,
    usuario_id BIGINT,
    curso_id BIGINT,

    PRIMARY KEY (id),

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)
);