CREATE TABLE tipo (id serial PRIMARY KEY, nome varchar(255));

INSERT INTO
	tipo (nome)
VALUES
	('admin');

INSERT INTO
	tipo (nome)
VALUES
	('especialista');

INSERT INTO
	tipo (nome)
VALUES
	('normal');

CREATE TABLE usuario (
	id serial PRIMARY KEY,
	nome varchar(255),
	senha varchar(255),
	hash varchar(255),
	ativo boolean,
	tipo_id int,
	CONSTRAINT fk_tipo FOREIGN KEY (tipo_id) REFERENCES tipo(id)
);

INSERT INTO
	usuario (nome, senha, hash, ativo, tipo_id)
VALUES
	(
		'admin',
		'$2a$12$8s6qu3dz6kpzuLYUzMR1QuTTAakcMRMsf2aptaFiUJ4wjtgsErrZq',
		'$2a$12$8s6qu3dz6kpzuLYUzMR1QuTTAakcMRMsf2aptaFiUJ4wjtgsErrZq',
		true,
		1
	);

CREATE TABLE playlist (
	id serial PRIMARY KEY,
	nome varchar(255),
	usuario_id int,
	CONSTRAINT fk_usuario FOREIGN KEY(usuario_id) REFERENCES usuario(id)
);

INSERT INTO
	playlist (nome, usuario_id)
VALUES
	('videos', 1);

CREATE TABLE video (
	id serial PRIMARY KEY,
	titulo varchar(255) NOT NULL,
	link varchar(255) NOT NULL UNIQUE,
	autor_id int NOT NULL,
	privado boolean NOT NULL,
	categoria varchar(255) NOT NULL,
	playlist_id int,
	CONSTRAINT fk_autor FOREIGN KEY(autor_id) REFERENCES usuario(id),
	CONSTRAINT fk_playlist FOREIGN KEY(playlist_id) REFERENCES playlist(id)
);

CREATE TABLE fonte (
	id serial PRIMARY KEY,
	nome varchar(255),
	dados bytea
);