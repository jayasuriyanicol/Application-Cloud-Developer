-- CREAZIONE DATABASE E ACCESSO

CREATE DATABASE Cielo

\c cielo



-- CREAZIONE DB - Cielo

CREATE DOMAIN PosInteger INTEGER
    check(value >= 0 );

CREATE DOMAIN StringaM VARCHAR (100);

CREATE DOMAIN CodIATA CHAR(3);



-- CREAZIONE DELLE TABELLE - PRE MANIPOLAZIONE

BEGIN TRANSACTION;
SET constraints all deferred;

CREATE TABLE Compagnia(

    nome StringaM NOT NULL,
    annoFondaz PosInteger NULL,

    PRIMARY KEY(nome)
);



CREATE TABLE Aeroporto(

    codice CodIATA NOT NULL,
    nome StringaM NOT NULL,

    PRIMARY KEY (codice)
);



CREATE TABLE LuogoAeroporto(

    aeroporto CodIATA NOT NULL,
    citta StringaM NOT NULL,
    nazione StringaM NOT NULL,

    PRIMARY KEY(aeroporto),
    FOREIGN KEY (aeroporto) REFERENCES Aeroporto(codice) deferrable
);



ALTER TABLE Aeroporto ADD FOREIGN KEY(codice) REFERENCES LuogoAeroporto(aeroporto) deferrable;

CREATE TABLE ArrPart(
   
    codice PosInteger NOT NULL,
    comp StringaM NOT NULL,
    arrivo CodIATA NOT NULL,
    partenza CodIATA NOT NULL,

    PRIMARY KEY(codice,comp),
    FOREIGN KEY (arrivo)  REFERENCES Aeroporto(codice),
    FOREIGN KEY (partenza) REFERENCES Aeroporto (codice)

);


CREATE TABLE Volo(

    codice PosInteger NOT NULL,
    comp StringaM NOT NULL,
    durataMinuti PosInteger NOT NULL,

    PRIMARY KEY (codice,comp),
    FOREIGN KEY (comp)  REFERENCES Compagnia(nome),
    FOREIGN  KEY (codice,comp) REFERENCES ArrPart(codice,comp) deferrable
);



ALTER TABLE ArrPart ADD FOREIGN KEY (codice,comp) REFERENCES Volo(codice,comp) deferrable;


commit;


