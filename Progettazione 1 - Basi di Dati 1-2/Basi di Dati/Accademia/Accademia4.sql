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


-- POPOLAMENTO DELLE TABELLE

INSERT INTO Persona VALUES
(1, 'Anna', 'Bianchi', 'Ricercatore', 30000),
(2, 'Mario', 'Rossi', 'Ricercatore', 32000),
(3, 'Barbara', 'Burso', 'Ricercatore', 31000),
(4, 'Gino', 'Spada', 'Ricercatore', 30500),
(5, 'Andrea', 'Verona', 'Professore Associato', 45000),
(6, 'Dario', 'Basile', 'Ricercatore', 33000),
(7, 'Leonardo', 'Vitali', 'Professore Ordinario', 50000),
(8, 'Paolo', 'Valentini', 'Professore Associato', 47000),
(9, 'Giulia', 'Costa', 'Ricercatore', 31500),
(10, 'Carla', 'Martinelli', 'Ricercatore', 30000);


INSERT INTO Progetto VALUES
(1, 'Artemide', '2000-01-01', '2002-12-31', 255000),
(2, 'Pegasus', '2012-01-01', '2014-12-31', 330000),
(3, 'WineSharing', '1999-01-01', '2003-12-31', 998000),
(4, 'Simap', '2010-02-01', '2014-03-17', 158000),
(5, 'DropDiscovery', '2010-09-13', '2013-01-20', 99000);



INSERT INTO WP VALUES
(3, 1, 'Dissemination', '2000-02-01', '2002-01-01'),
(4, 1, 'WP3', '2000-05-01', '2002-01-01'),
(4, 2, 'Main Activity', '2010-02-01', '2012-01-01'),
(4, 3, 'WP2', '2012-02-01', '2013-01-01'),
(1, 1, 'WP1', '1999-02-01', '2000-01-01'),
(2, 1, 'Main Research', '2010-03-01', '2011-12-01'),
(1, 2, 'State of the Art', '1999-01-01', '2000-01-01');



INSERT INTO AttivitaProgetto VALUES
(1, 1, 3, 1, '2001-03-01', 'Ricerca e Sviluppo', 6),
(2, 2, 3, 1, '2001-04-01', 'Management', 4),
(3, 3, 3, 1, '2001-05-01', 'Dimostrazione', 3),
(4, 4, 3, 1, '2001-06-01', 'Altro', 2);



INSERT INTO AttivitaNonProgettuale VALUES
(1, 1, 'Didattica', 1, '2011-03-15', 6),
(2, 2, 'Didattica', 1, '2011-05-07', 4),
(3, 3, 'Didattica', 1, '2012-04-18', 3),
(4, 4, 'Didattica', 1, '2014-04-01', 4),
(5, 1, 'Didattica', 1, '2014-04-03', 5);




INSERT INTO Assenza VALUES
(1, 1, 'Maternita', '2012-02-01', 4),
(2, 2, 'Malattia', '2013-03-01', 6),
(3, 3, 'Chiusura Universitaria', '2014-08-15', 8);



-- QUERY


-- 1. Quali sono i cognomi distinti di tutti gli strutturati

SELECT distinct cognome
FROM persona;


-- 2. Quali sono i Ricercatori (con nome e cognome) ?

SELECT nome, cognome
FROM persona
WHERE posizione = 'Ricercatore';



-- 3. Quali sono i Professori Associati il cui cognome comincia con la lettera 'V' ?

SELECT nome,cognome
FROM persona
WHERE posizione = 'Professore Associato' AND cognome LIKE 'V%';


-- 4. Quali sono i Porfessori (sia Associati che Ordinari) il cui cognome comincia con la lettera 'V?

SELECT nome,cognome
FROM persona
WHERE posizione ='Professore Associato' AND posizione= 'Professore Ordinario' AND cognome LIKE 'V%';


-- 5. Quali sonon i Progetti già terminati alla data odierna?

SELECT id, nome, inizio, fine, budget
FROM progetto
WHERE fine < CURRENT_DATE;


-- 6. Quali sono i nomi di tutti i Progetti ordinati in ordine crescente di data di inizio?

SELECT nome
FROM Progetto
ORDER BY inizio ASC;


-- 7. Quali sono i nomi dei WP ordinati in ordine crescente (per nome)?

SELECT nome 
FROM WP
ORDER BY nome ASC; -- OPPURE si può utilizaare la forma senza ASC dato che viene ordinata già in ordine crescente tramite l'ORDER BY



-- 8. Quali sono (distinte) le cause di assenza di tutti gli strutturati?

SELECT distinct id, persona, tipo, giorno
FROM Assenza;


-- 9. Quali sono (distinte) le tipologie di attività di progetto di tutti gli strutturati?


SELECT distinct tipo
FROM AttivitaProgetto ap, Persona p
WHERE ap.persona = p.id;


-- oppure possiamo seguire una forma più complessa, senza utilizzare il WHERE ma bensì JOIN:

SELECT distinct ap.tipo
FROM AttivitaProgetto ap JOIN Persona p ON ap.persona = p.id:


-- 10. Quali sono i giorni distinti nei quali del personale ha effettuato attività non progettuali di tipo 'Didattica' ? Dare il risultato in ordine crescente

SELECT distinct p.id, p.nome,p.cognome, anp.giorno
FROM AttivitaNonProgettuale anp, Persona p
WHERE anp.persona = p.id AND anp.tipo = 'Didattica'
ORDER BY anp.giorno;