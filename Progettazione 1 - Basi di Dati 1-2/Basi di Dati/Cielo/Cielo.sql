-- CREAZIONE DATABASE E ACCESSO

CREATE DATABASE Cielo

\c cielo



-- CREAZIONE DB - Cielo

CREATE DOMAIN PosInteger INTEGER
    check(value >= 0 );

CREATE DOMAIN StringaM VARCHAR (100);

CREATE DOMAIN CodIATA CHAR(3);



-- CREAZIONE DELLE TABELLE - PRE MANIPOLAZIONE

 BEGIN transaction;

 SET constraints all deferred;
 commit

CREATE TABLE Volo(

    codice PosInteger NOT NULL,
    comp StringaM NOT NULL,
    durataMinuti PosInteger NOT NULL,

    PRIMARY KEY (codice,comp),
    FOREIGN KEY (comp)  REFERENCES Compagnia(nome),
    FOREIGN  KEY (codice,comp) REFERENCES ArrPart(codice,comp)
);



CREATE TABLE ArrPart(
   
    codice PosInteger NOT NULL,
    comp StringaM NOT NULL,
    arrivo CodIATA NOT NULL,
    partenza CodIATA NOT NULL,

    PRIMARY KEY(codice,comp),
    FOREIGN KEY (codice, comp) REFERENCES Volo(codice,comp),
    FOREIGN KEY (arrivo)  REFERENCES Aeroporto(codice),
    FOREIGN KEY (partenza) REFERENCES Aeroporto (codice)

);




CREATE TABLE Aeroporto(

    codice CodIATA NOT NULL,
    nome StringaM NOT NULL,

    PRIMARY KEY (codice),
    FOREIGN KEY codice REFERENCES LuogoAeroporto(aeroporto)
);



CREATE TABLE LuogoAeroporto(

    aeroporto CodIATA NOT NULL,
    citta StringaM NOT NULL,
    nazione StringaM NOT NULL,

    PRIMARY KEY(aeroporto),
    FOREIGN KEY aeroporto REFERENCES Aeroporto(codice)
);


CREATE TABLE Compagnia(

    nome StringaM NOT NULL,
    annoFondaz PosInteger,

    PRIMARY KEY(nome)
);