CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,

    autor_nombre VARCHAR(255) NOT NULL,
    autor_email VARCHAR(255) NOT NULL,
    autor_password VARCHAR(255) NOT NULL,
    autor_perfil VARCHAR(255) NOT NULL,

    curso_nombre VARCHAR(255) NOT NULL,
    curso_categoria VARCHAR(255) NOT NULL,


    PRIMARY KEY(id)
);
