-- CREAZIONE DEL DATABASE ACCADEMIA 3
CREATE DATABASE accademia3;
\c accademia3

-- CREAZIONE DEI TIPI ENUM E DOMINI

CREATE TYPE Strutturato AS ENUM ('Ricercatore', 'Professore Associato', 'Professore Ordinario');

CREATE TYPE LavoroProgetto AS ENUM ('Ricerca e Sviluppo', 'Dimostrazione', 'Management', 'Altro');

CREATE TYPE LavoroNonProgettuale AS ENUM ('Didattica', 'Ricerca', 'Missione', 'Incontro Dipartimentale', 'Incontro Accademico');

CREATE TYPE CausaAssenza AS ENUM ('Chiusura Universitaria', 'Maternita', 'Malattia');

CREATE DOMAIN PosInteger AS INTEGER
    CHECK (VALUE > 0);

CREATE DOMAIN StringaM AS VARCHAR(100);

CREATE DOMAIN NumeroOre AS INTEGER
    CHECK (VALUE >= 0 AND VALUE <= 8);

CREATE DOMAIN Denaro AS REAL
    CHECK (VALUE >= 0);


-- CREAZIONE DELLE TABELLE

CREATE TABLE Persona (
    id PosInteger NOT NULL,
    nome StringaM NOT NULL,
    cognome StringaM NOT NULL,
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
    PRIMARY KEY (id),
    CHECK (inizio < fine),
    UNIQUE (nome)
);


CREATE TABLE WP (
    progetto PosInteger NOT NULL,
    id PosInteger NOT NULL,
    nome StringaM NOT NULL,
    inizio DATE NOT NULL,
    fine DATE NOT NULL,
    PRIMARY KEY (progetto, id),
    CHECK (inizio < fine),
    FOREIGN KEY (progetto) REFERENCES Progetto(id),
    UNIQUE (progetto, nome)
);


CREATE TABLE AttivitaProgetto (
    id PosInteger NOT NULL,
    persona PosInteger NOT NULL,
    progetto PosInteger NOT NULL,
    wp PosInteger NOT NULL,
    giorno DATE NOT NULL,
    tipo LavoroProgetto NOT NULL,
    oreDurata NumeroOre NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (persona) REFERENCES Persona(id),
    FOREIGN KEY (progetto, wp) REFERENCES WP(progetto, id)
);


CREATE TABLE AttivitaNonProgettuale (
    id PosInteger NOT NULL,
    persona PosInteger NOT NULL,
    tipo LavoroNonProgettuale NOT NULL,
    wp PosInteger NOT NULL,
    giorno DATE NOT NULL,
    oreDurata NumeroOre NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (persona) REFERENCES Persona(id)
    
);


CREATE TABLE Assenza (
    id PosInteger NOT NULL,
    persona PosInteger NOT NULL,
    tipo CausaAssenza NOT NULL,
    giorno DATE NOT NULL,
    oreDurata NumeroOre NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (persona) REFERENCES Persona(id),
    UNIQUE (persona, giorno)
);


-- POPOLAMENTO delle tabelle precedentemente create

INSERT INTO persona VALUES (1,'Nicol','Jayasuriya','Professore Associato', 3100.45);
INSERT INTO persona VALUES (2,'Cristiano','Coccia','Ricercatore', 1000.45);
INSERT INTO persona VALUES (3,'Michael','Giorgi','Professore Ordinario', 1550.45);

SET Datestyle = 'ISO, DMY'; -- Utilizziamo questa notazione solo per l'inserimento semplificato europeo, ma verrà visualizzato come formato nella tabelle risultante come inglese/americano

INSERT INTO progetto VALUES (1, 'ReenbacRailways',  '22-05-2025', '24-11-2030', 3000000.00);
INSERT INTO progetto VALUES (2, 'ProjectFarm',  '28-08-2025', '29-11-2030', 50000.00);
INSERT INTO progetto VALUES (3, 'AlphaPharma',  '07-11-2025', '09-04-2040', 100000.00);
SET Datestyle = 'ISO, DMY';

INSERT INTO wp VALUES (1,1,'Reenbac Train System', '20-05-2025', '29-11-2030');

SET Datestyle = 'ISO, DMY';

INSERT INTO AttivitaProgetto VALUES (1,1,1,1,'19-05-2024', 'Ricerca e Sviluppo', 8 );

SET Datestyle = 'ISO, DMY';

INSERT INTO AttivitaNonProgettuale VALUES (1,1,'Ricerca',1,'18-05-2024', 5);

SET Datestyle = 'ISO, DMY';

INSERT INTO Assenza VALUES (1,1,'Malattia','19-05-2024', 8);
