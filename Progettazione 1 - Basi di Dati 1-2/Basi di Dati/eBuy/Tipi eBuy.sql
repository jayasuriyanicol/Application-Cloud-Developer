--Creazione dei tipi di dato eBuy

CREATE DATABASE eBuy;

\c eBuy

BEGIN TRANSACTION
SET CONSTRAINTS ALL DEFERRED;


CREATE DOMAIN IntGEZ as INTEGER
    CHECK (VALUE >=0 );

CREATE DOMAIN RealGEZ as INTEGER
    CHECK (VALUE >=0 );

CREATE DOMAIN RealGZ as REAL
    CHECK (VALUE > 0 );

CREATE DOMAIN IntG1 as INTEGER
    CHECK (VALUE > 1);

CREATE DOMAIN IntG2 as INTEGER
    CHECK (VALUE > 1);

CREATE DOMAIN Voto as INTEGER
    CHECK (VALUE > 0 AND VALUE <= 5);

CREATE DOMAIN Stringa as VARCHAR;

CREATE DOMAIN Url as VARCHAR
      CHECK ( VALUE ~ [-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*));


CREATE TYPE Condizione as ENUM
('Ottimo', 'Buono','Discreto', 'Da Sistemare');
