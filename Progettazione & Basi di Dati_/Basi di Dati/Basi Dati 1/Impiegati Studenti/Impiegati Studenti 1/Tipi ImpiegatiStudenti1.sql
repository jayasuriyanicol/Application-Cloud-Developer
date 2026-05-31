CREATE DATABASE ImpiegatiStudenti1;

\c ImpiegatiStudenti1


BEGIN TRANSACTION
SET CONSTRAINTS ALL DEFERRED;



CREATE DOMAIN Stringa AS VARCHAR;

CREATE DOMAIN IntGEZ as INTEGER
    CHECK (VALUE >=0 );

CREATE DOMAIN RealGEZ as INTEGER
    CHECK (VALUE >=0 );


CREATE TYPE Ruolo as ENUM
    ('Direttore', 'Segretario', 'Progettista');


CREATE DOMAIN CodiceFiscale as CHAR(16)
    CHECK(value ~ '[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$');