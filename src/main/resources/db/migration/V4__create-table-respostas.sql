create table respostas(
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    mensagem VARCHAR(100) NOT NULL,
    dataCriacao DATE NOT NULL,
    solucao VARCHAR(250) NOT NULL,
    usuario_id BIGINT,
    topico_id BIGINT,

    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (topico_id) REFERENCES topicos(id)
);