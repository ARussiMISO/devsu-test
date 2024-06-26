CREATE TABLE IF NOT EXISTS cliente (
    clienteId INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nombre VARCHAR(100) NOT NULL,
    genero CHAR(1) NOT NULL,
    edad INTEGER NOT NULL,
    identificacion BIGINT UNIQUE NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    estado BOOLEAN NOT NULL
);

