-- CREAZIONE DEL DB ORIDNI E FATTURE 1


CREATE DATABASE OridniFatture1

\c OrdiniFaitture1

BEGIN TRANSACTION;

SET CONSTRAINTS ALL DEFERRED;


CREATE TYPE Stringa as VARCHAR;

CREATE TYPE Telefono as VARCHAR;


CREATE TYPE RealGEZ as REAL
CHECK(value >= 0);

CREATE TYPE IntGEZ as INTEGER
CHECK( value >= 0);


CREATE DOMAIN Indirizzo as  (
 
 via Stringa,
 civico Stringa,
 cap  tringa(5)
    
)