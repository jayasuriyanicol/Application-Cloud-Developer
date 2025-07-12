-- CREAZIONE DEL DATABASE ACCADEMIA 3
CREATE DATABASE accademia4;
\c accademia4

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

INSERT INTO Persona VALUES
(0, 'Anna', 'Bianchi', 'Ricercatore', 30000),
(1, 'Mario', 'Rossi', 'Ricercatore', 32000),
(2, 'Barbara', 'Burso', 'Ricercatore', 31000),
(3, 'Gino', 'Spada', 'Ricercatore', 30500),
(7, 'Andrea', 'Verona', 'Professore Associato', 45000),
(12, 'Dario', 'Basile', 'Ricercatore', 33000),
(15, 'Leonardo', 'Vitali', 'Professore Ordinario', 50000),
(16, 'Paolo', 'Valentini', 'Professore Associato', 47000),
(18, 'Giulia', 'Costa', 'Ricercatore', 31500),
(20, 'Carla', 'Martinelli', 'Ricercatore', 30000);


INSERT INTO Progetto VALUES
(0, 'Artemide', '2000-01-01', '2002-12-31', 255000),
(1, 'Pegasus', '2012-01-01', '2014-12-31', 330000),
(2, 'WineSharing', '1999-01-01', '2003-12-31', 998000),
(3, 'Simap', '2010-02-01', '2014-03-17', 158000),
(4, 'DropDiscovery', '2010-09-13', '2013-01-20', 99000);


INSERT INTO WP VALUES
(2, 2, 'Dissemination', '2000-02-01', '2002-01-01'),
(3, 1, 'Main Activity', '2010-02-01', '2012-01-01'),
(0, 0, 'State of the Art', '1999-01-01', '2000-01-01'),
(1, 1, 'Main Research', '2010-03-01', '2011-12-01'),
(0, 0, 'WP1', '1999-01-01', '2000-06-01'),
(1, 1, 'WP2', '2010-06-01', '2011-06-01'),
(2, 2, 'WP3', '2000-01-01', '2002-01-01');



INSERT INTO AttivitaProgetto VALUES
(0, 0, 2, 2, '2001-03-01', 'Ricerca e Sviluppo', 6),
(1, 1, 2, 2, '2001-04-01', 'Management', 4),
(2, 2, 2, 2, '2001-05-01', 'Dimostrazione', 3),
(3, 3, 2, 2, '2001-06-01', 'Altro', 2);


INSERT INTO AttivitaNonProgettuale VALUES
(0, 0, 'Didattica', 0, '2011-03-15', 6),
(1, 1, 'Didattica', 0, '2011-05-07', 4),
(2, 2, 'Didattica', 0, '2012-04-18', 3),
(3, 3, 'Didattica', 0, '2014-04-01', 4),
(4, 0, 'Didattica', 0, '2014-04-03', 5);
