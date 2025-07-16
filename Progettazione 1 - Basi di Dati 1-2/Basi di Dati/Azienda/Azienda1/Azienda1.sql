-- Implementazione in Linguaggio SQL di Azienda1
BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;


--Implementazione di TIPI e DOMINI

CREATE DOMAIN RealGEZ AS integer
    CHECK (value >= 0);

CREATE DOMAIN Stringa AS VARCHAR;

CREATE TYPE Denaro AS (
    valore RealGEZ,
    valuta VARCHAR(3)
);

CREATE TYPE Indirizzo AS (
    via Stringa,
    civico Stringa,
    CAP VARCHAR(5)
);



-- Creazione delle Tabelle per la pre - manipolazione e inserimento dei dati


CREATE TABLE Progetto (
    id integer PRIMARY KEY,
    nome stringa NOT NULL,
    budget Denaro NOT NULL
);



CREATE TABLE Impiegato (
    id integer PRIMARY KEY,
    nome stringa NOT NULL,
    cognome stringa NOT NULL,
    data_nascita date NOT NULL,
    stipendio denaro NOT NULL

);



CREATE TABLE partecipa (
    impiegato integer NOT NULL,
    progetto integer NOT NULL,

    PRIMARY KEY (impiegato, progetto),

    FOREIGN KEY (impiegato) REFERENCES impiegato(id),
    FOREIGN KEY (progetto) REFERENCES progetto(id)
);



CREATE TABLE Dipartimento (
    id integer PRIMARY KEY,
    nome stringa NOT NULL,
    telefono stringa NOT NULL
);




CREATE TABLE afferisce (
    impiegato integer PRIMARY KEY,
    dipartimento integer NOT NULL,
    data_afferenza date NOT NULL,

    FOREIGN KEY (impiegato) REFERENCES impiegato(id),
    FOREIGN KEY (dipartimento) REFERENCES dipartimento(id)
);



CREATE TABLE dirige (
    
    impiegato integer NOT NULL,
    dipartimento integer PRIMARY KEY,

    FOREIGN KEY (impiegato) REFERENCES impiegato(id),
    FOREIGN KEY (dipartimento) REFERENCES dipartimento(id)
);

COMMIT;
