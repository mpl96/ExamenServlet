create table IF NOT EXISTS Languages(
	language varchar(50),
	PRIMARY KEY (language),
);

create table IF NOT EXISTS Countries(
	country varchar(50),
	languageCountry varchar(50),
	PRIMARY KEY (country),
);