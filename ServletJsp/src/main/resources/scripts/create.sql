create table IF NOT EXISTS Idiomas(
	idioma varchar(50),
	PRIMARY KEY (idioma),
);

create table IF NOT EXISTS Paises(
	pais varchar(50),
	idiomaPais varchar(50),
	PRIMARY KEY (pais),
);