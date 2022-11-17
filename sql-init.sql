CREATE TABLE tipo (
	id serial PRIMARY KEY,
	nome varchar(255)
);

CREATE TABLE usuario (
	id serial PRIMARY KEY,
	nome varchar(255),
	senha varchar(255),
	hash varchar(255),
	ativo boolean,
	tipo_id int,
	CONSTRAINT fk_tipo
		FOREIGN KEY (tipo_id)
			REFERENCES tipo(id)
);

CREATE TABLE playlist (
	id serial PRIMARY KEY,
	nome varchar(255)
);

CREATE TABLE video (
	id serial PRIMARY KEY,
	titulo varchar(255) NOT NULL,
	url varchar(255) NOT NULL,
	autor_id int NOT NULL,
	privado boolean NOT NULL,
	categoria varchar(255) NOT NULL,
	playlist_id int,
	CONSTRAINT fk_autor
		FOREIGN KEY(autor_id) 
			REFERENCES usuario(id),
	CONSTRAINT fk_playlist
		FOREIGN KEY(playlist_id)
			REFERENCES playlist(id)
);