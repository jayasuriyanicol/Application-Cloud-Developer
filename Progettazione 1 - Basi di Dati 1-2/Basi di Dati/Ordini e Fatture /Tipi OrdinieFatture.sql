-- CREAZIONE DEL DB ORIDNI E FATTURE 1


CREATE DATABASE OridniFatture1

\c OrdiniFaitture1

BEGIN TRANSACTION;

SET CONSTRAINTS ALL DEFERRED;


-- Creazione dei DOMINI NUMERICI

CREATE DOMAIN RealGEZ as REAL
CHECK(value >= 0);

CREATE DOMAIN IntGEZ as INTEGER
CHECK( value >= 0);

CREATE DOMAIN Real as REAL
CHECK( value >= 0 and value <= 1);


-- Creazione dei DOMINI 

CREATE DOMAIN Stringa as VARCHAR;

CREATE DOMAIN Telefono as VARCHAR;

CREATE DOMAIN CodiceFiscale as Stringa
CHECK (value ~ '[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$');

CREATE DOMAIN PartitaIva as Stringa
CHECK (value ~ '^[0-9]{11}$');

CREATE DOMAIN Telefono as Stringa
CHECK (value ~ '^\+[1-9][0-9]{0,2} [0-9]{6,13}$');

create domain Email as Stringa
CHECK (value ~ '^[\w\.-]+@[\w\.-]+\.\w{2,}$');


-- Creazione dei TIPI 

CREATE DOMAIN Indirizzo as  (
 
 via Stringa,
 civico Stringa,
 CAP  tringa(5)
    
);


CREATE TYPE Stato as enum (

    'in preparazione ',
    'inviato',
    'da saldare',
    'saldato'
);


COMMIT;