CREATE VoliAerei1;
\c VoliAerei1

BEGIN transaction;

SET CONSTRAINT ALL deffer;

CREATE DOMAIN Stringa AS VARCHAR,

CREATE DOMAIN IntG1900  AS INTEGER -- Valore intero maggiore di 1900
check (value > 1900);

CREATE DOMAIN IntGZ AS INTEGER -- Valore intero maggiore di 0
check (value > 0);

CREATE DOMAIN IntGEZ  AS INTEGER -- Valore intero maggiore o uguale a 0
check (value>=0);



CREATE TABLE Nazione (

    id INTEGER PRIMARY KEY,
    nome Stringa NOT NULL


);


CREATE TABLE Citta (
    id INTEGER PRIMARY KEY,
    nome Stringa NOT NULL,
    n_abitati IntGZ NOT NULL,

    nazione INTEGER NOT NULL,
    FOREIGN KEY (nazione) REFERENCES nazione(id)
);



CREATE TABLE Aereoporto (

    id INTEGER PRIMARY KEY,
    codice Stringa NOT NULL,
    nome Stringa NOT NULL,

    Citta INTEGER NOT NULL,
    FOREIGN KEY (citta) REFERENCES citta(id)

);

CREATE TABLE CompagniaAerea (

    id INTEGER PRIMARY KEY,
    nome Stringa NOT NULL,
    fondazione IntG1900 NOT NULL,

    citta INTEGER NOT NULL,
    partenza INTEGER NOT NULL,
    arrivo INTEGER NOT NULL, 

    FOREIGN KEY (citta) REFERENCES citta(id),
    FOREIGN KEY (partenza) REFERENCES partenza(id),
    FOREIGN KEY (arrivo) REFERENCES arrivo(id)

);


CREATE TABLE Volo (

    id INTEGER PRIMARY KEY,
    codice Stringa NOT NULL,
    durata_in_minuti IntGZ NOT NULL,
    
    partenza INTEGER NOT NULL,
    arrivo INTEGER NOT NULL,
    compagnia INTEGER NOT NULL,

    FOREIGN KEY (partenza) REFERENCES Aereoporto (id),
    FOREIGN KEY (arrivo) REFERENCES Aereoporto (id),
    FOREIGN KEY (compagnia) REFERENCES CompagniaAerea(id)

);