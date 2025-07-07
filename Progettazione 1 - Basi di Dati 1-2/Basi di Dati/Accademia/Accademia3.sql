-- CREAZIONE DEL DataBase ACCADEMIA 3+

--CREAZIONE DELL'INSIEME DEI Domini:

CREATE TYPE Strutturato as ENUM ('Ricercatore','Professore Associato','Professore Ordinario');

CREATE TYPE LavoroProgetto as ENUM ('Ricerca e Sviluppo', 'Dimostrazione', 'Management', 'Altro');

CREATE TYPE LavoroNonProgettuale as ENUM ('Didattica','Ricerca','Missione','Incontro Dipartimentale', 'Incontro Accademico');

CREATE TYPE CausaAssenza as ENUM ('Chiusura Universitaria', 'Maternita', 'Malattia');

CREATE DOMAIN PosInteger as INTEGER
   CHECK (value > 0);

CREATE DOMAIN StringaM as VARCHAR(100);

CREATE DOMAIN NumeroOre as INTEGER
    CHECK (0 => value <= 8);

CREATE DOMAIN Denaro as REAL
    CHECK (value >= 0);



-- CREAZIONE DELLE TABELLE 


CREATE TABLE Persona (
    
    id PosInteger NOT NULL,
    nome StringaM NOT NULL,
    cognome StringaM  NOT NULL,
    posizione Strutturato NOT NULL,
    stipendio Denaro NOT NULL,

    PRIMARY KEY (id)
);


CREATE TABLE Progetto (

    id PosInteger NOT NULL,
    nome StringaM NOT NULL,
    inizio DATE NOT NULL,
    fine DATE NOT NULL,
    budget Denaro NOT NULL,

    PRIMARY KEY (id)
    FOREIGN KEY  

);


CREATE TABLE WP (

    progetto PosInteger NOT NULL,
    id PosInteger NOT NULL,
    nome StringaM NOT NULL,
    inizio DATE NOT NULL,
    fine DATE NOT NULL,
);


