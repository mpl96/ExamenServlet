create table IF NOT EXISTS IDIOMAS(
	idioma varchar(25) PRIMARY KEY
);

create table IF NOT EXISTS PAISES(
	idPais int PRIMARY KEY,
	pais varchar(25),
	idIoma varchar(25),
	FOREIGN KEY(idioma) REFERENCES IDIOMAS(idioma)
);