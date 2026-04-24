DROP DATABASE IF EXISTS instituto;
CREATE DATABASE instituto;

USE instituto;

DROP TABLE IF EXISTS estudiante;
CREATE TABLE estudiante (
NIA CHAR(8) PRIMARY KEY
, Nombre VARCHAR(30) NOT NULL
, FechaNacimiento DATE NOT NULL
, CONSTRAINT CK_NIA CHECK (NIA REGEXP '^[0-9]$')
);

INSERT INTO estudiante (NIA, Nombre, FechaNacimiento)
VALUES ('10098145', 'Eric Ramos Pastor', '2001/01/18')
	, ('10729130', 'Núria Giménez Santos', '2006/11/14')
	, ('10729131', 'Antonio Giménez Santos', '2006/11/14')
	, ('10048100', 'Mario Rico Baile', '2001/06/27')
	, ('12009837', 'Belén López Fuster', '2013/02/12');