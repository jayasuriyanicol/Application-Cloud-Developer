-- Creazione ACCADEMIA 6


CREATE DATABASE Accademia5

\c Accademia5

 
-- CREAZIONE TIPI E DOMINI

CREATE TYPE Strutturato AS ENUM ('Ricercatore', 'Professore Associato', 'Professore Ordinario');

CREATE TYPE LavoroProgetto AS ENUM ('Ricerca e Sviluppo', 'Dimostrazione', 'Management', 'Altro');

CREATE TYPE LavoroNonProgettuale AS ENUM ('Didattica', 'Ricerca', 'Missione', 'Incontro Dipartimentale', 'Incontro Accademico', 'Altro');

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
    id PosInteger,
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


begin transaction;

set constraints all deferred;


INSERT INTO Persona(id, nome, cognome, posizione, stipendio)
VALUES
('1',	'Anna',		'Bianchi', 		'Ricercatore', 			'45500.30'),
('2',	'Mario',	'Rossi', 		'Ricercatore', 			'35500.00'),
('3',	'Barbara',	'Burso', 		'Ricercatore', 			'40442.50'),
('4',	'Gino',		'Spada', 		'Ricercatore', 			'35870.90'),
('5',	'Aurora',	'Bianchi', 		'Professore Associato', '43500.50'),
('6',	'Guido',	'Spensierato', 	'Professore Associato', '38221.00'),
('7',	'Consolata','Ferrari',	 	'Professore Associato', '29200.10'),
('8',	'Andrea',	'Verona', 		'Professore Associato', '39002.05'),
('9',	'Asia',		'Giordano', 	'Professore Ordinario', '45200.10'),
('10', 	'Carlo',	'Zante', 		'Professore Ordinario', '40230.00'),
('11', 	'Ginevra',	'Riva', 		'Professore Ordinario', '39955.00'),
('12', 	'Davide',	'Quadro', 		'Professore Ordinario', '36922.10'),
('13', 	'Dario',	'Basile', 		'Ricercatore', 			'42566.00'),
('14', 	'Silvia',	'Donati', 		'Professore Ordinario', '38005.00'),
('15', 	'Fiorella', 'Martino', 		'Professore Associato', '35544.50'),
('16', 	'Leonardo', 'Vitali', 		'Professore Ordinario', '38779.80'),
('17', 	'Paolo',	'Valentini', 	'Professore Associato', '39200.00'),
('18', 	'Emilio',	'Greco', 		'Professore Associato', '42020.00'),
('19', 	'Giulia',	'Costa', 		'Ricercatore', 			'40220.00'),
('20', 	'Elisa',	'Longo', 		'Professore Associato', '39001.00'),
('21', 	'Carla',	'Martinelli', 	'Ricercatore', 			'42030.20');



INSERT INTO Progetto(id, nome, inizio, fine, budget) VALUES
('1',	'Artemide',		'2000-01-01',	'2002-12-31',	'255000'),
('2',	'Pegasus',		'2012-01-01',	'2014-12-31',	'330000'),
('3',	'WineSharing',	'1999-01-01',	'2003-12-31',	'998000'),
('4',	'Simap',		'2010-02-01',	'2014-03-17',	'158000'),
('5',	'DropDiscovery','2010-09-13',	'2013-01-20',	'99000');



INSERT INTO WP(progetto, id, nome, inizio, fine) VALUES
('1',	'1',	'WP1',				'2000-01-01',	'2000-12-31'),
('1',	'2',	'WP2',				'2001-01-01',	'2001-12-31'),
('1',	'3',	'WP3',				'2002-01-01',	'2002-12-31'),
('2',	'1',	'WP1',				'2012-01-01',	'2012-12-31'),
('2',	'2',	'WP2',				'2012-01-01',	'2012-12-31'),
('2',	'3',	'WP3',				'2013-01-01',	'2013-12-31'),
('3',	'2',	'Main Activity',	'1999-01-01',	'2003-12-31'),
('4',	'1',	'State of the Art',	'2012-01-01',	'2012-12-31'),
('4',	'2',	'Main Research',	'2013-01-01',	'2013-12-31'),
('4',	'3',	'Dissemination',	'2014-01-01',	'2014-03-17');



INSERT INTO AttivitaProgetto(id, persona, progetto, wp, giorno, tipo, oreDurata)
VALUES
('1',	'1',	'2',	'1',	'2012-04-15',	'Ricerca e Sviluppo',	'8'),
('2',	'1',	'2',	'1',	'2012-04-16',	'Ricerca e Sviluppo',	'8'),
('3',	'1',	'2',	'1',	'2012-04-17',	'Ricerca e Sviluppo',	'8'),
('4',	'1',	'2',	'1',	'2012-04-18',	'Ricerca e Sviluppo',	'8'),
('5',	'9',	'2',	'3',	'2013-03-15',	'Dimostrazione',		'8'),
('6',	'11',	'2',	'1',	'2012-06-03',	'Ricerca e Sviluppo',	'8'),
('7',	'3',	'2',	'2',	'2012-04-22',	'Dimostrazione',		'7'),
('8',	'5',	'4',	'2',	'2013-01-19',	'Management',			'6'),
('9',	'12',	'4',	'3',	'2014-02-15',	'Altro',				'5'),
('10',	'1',	'4',	'3',	'2014-03-08',	'Ricerca e Sviluppo',	'6'),
('11',	'5',	'3',	'2',	'2000-01-19',	'Management',			'2'),
('12',  '11',   '3',    '2',    '2012-04-22',   'Altro',                '6'),
('13',  '11',   '3',    '2',    '2012-04-23',   'Altro',                '6');



INSERT INTO AttivitaNonProgettuale(id, persona, tipo, giorno, oreDurata) 
VALUES
('1',	'9',	'Incontro Dipartimentale',	'2011-06-01',	'4'),
('2',	'9',	'Didattica',				'2011-03-15',	'8'),
('3',	'9',	'Incontro Dipartimentale',	'2011-06-15',	'4'),
('4',	'3',	'Didattica',				'2014-04-01',	'4'),
('5',	'3',	'Didattica',				'2014-04-03',	'4'),
('6',	'2',	'Didattica',				'2014-04-03',	'8'),
('7',	'5',	'Incontro Accademico',		'2012-11-25',	'7'),
('8',	'8',	'Missione',					'2013-07-07',	'3'),
('9',	'6',	'Altro',					'2012-12-15',	'6'),
('10',	'1',	'Didattica',				'2012-04-18',	'4'),
('11',	'7',	'Didattica',				'2011-05-07',	'7');



INSERT INTO Assenza(id, persona, tipo, giorno) VALUES
('1',	'11',	'Malattia',				'2011-06-01'),
('2',	'11',	'Malattia',				'2011-06-02'),
('3',	'11',	'Malattia',				'2011-06-03'),
('4',	'11',	'Maternita',			'2011-06-04'),
('5',	'9',	'Malattia',				'2011-07-02'),
('6',	'20',	'Chiusura Universitaria','2013-06-29'),
('7',	'8',	'Malattia',				'2012-12-07'),
('8',	'1',	'Maternita',			'2013-10-27'),
('9',	'18',	'Chiusura Universitaria','2011-08-15'),
('10',	'16',	'Maternita',			'2010-12-12'),
('11',  '1',	'Malattia', 			'2012-04-18');

COMMIT;

-- SVOLGIMENTO QUERY ACCADEMIA6



--Definire in SQL le seguenti interrogazioni, in cui si chiedono tutti risultati distinti:



--1. Quanti sono gli strutturati di ogni fascia?

SELECT posizione AS RuoloPosizione, COUNT(*) as NumeroRuolo  
FROM Persona p 
GROUP BY p.posizione;


-- 2. Quanti sono gli strutturati con stipendio ≥ 40000?

SELECT COUNT(*) as Numero 
FROM Persona p 
WHERE p.stipendio >= 40000;



-- 3. Quanti sono i progetti già finiti che superano il budget di 50000?


SELECT COUNT(*) as ProgettiFIniti  
FROM Progetto p 
WHERE p.budget >= 50000 AND fine < CURRENT_DATE;

-- 4. Qual è la media, il massimo e il minimo delle ore delle attività relative al progetto
--‘Pegasus’ ?


SELECT AVG(ap.oreDurata) AS MediaDurata, MAX(ap.oreDurata) AS MassimaDurata,MIN(ap.oreDurata) AS MinimaDurata
FROM  AttivitaProgetto ap
WHERE ap.progetto = p.id AND p.nome = 'Pegasus';

--Per la formattazione è possibile utilizzare anche la funzione 'ROUND' -> ROUND((variabile),2)

-- 5. Quali sono le medie, i massimi e i minimi delle ore giornaliere dedicate al progetto
--‘Pegasus’ da ogni singolo docente?


SELECT p.id,p.nome,p.cognome,AVG(ap.oreDurata) AS MediaDurata, MAX(ap.oreDurata) AS MassimaDurata,MIN(ap.oreDurata) AS MinimaDurata
FROM  AttivitaProgetto ap,persona p
WHERE ap.progetto = 1 and  p.id = ap.persona
GROUP BY p.id,p.nome, p.cognome;




-- 6. Qual è il numero totale di ore dedicate alla didattica da ogni docente?

SELECT p.id, p.nome,p.cognome,SUM(anp.oreDurata) AS ore_didattica
FROM  Persona p, AttivitaNonProgettuale anp
WHERE anp.tipo = 'Didattica' AND p.id = anp.persona
GROUP BY p.id, p.nome,p.cognome;


-- 7. Qual è la media, il massimo e il minimo degli stipendi dei ricercatori?

SELECT AVG(p.stipendio) AS media, MAX(p.stipendio) AS massimo, MIN(p.stipendio) AS minimo
FROM Persona p
WHERE p.posizione = 'Ricercatore';


-- 8.Quali sono le medie, i massimi e i minimi degli stipendi dei ricercatori, dei professori
-- associati e dei professori ordinari?


SELECT p.posizione, AVG(p.stipendio) AS Media, MAX(p.stipendio) as Massimo ,MIN(p.stipendio) AS Minimo
FROM Persona p
WHERE p.posizione = 'Ricercatore' OR p.posizione = 'Professore Associato' OR p.posizione = 'Professore Ordinario'
GROUP BY p.posizione;



-- 9. Quante ore ‘Ginevra Riva’ ha dedicato ad ogni progetto nel quale ha lavorato?

SELECT pr.id AS id_progetto, pr.nome AS progetto, SUM(ap.oreDurata) AS oreDurata
FROM Persona p, Progetto pr, AttivitaProgetto ap
WHERE p.id = ap.persona AND p.nome = 'Ginevra' AND p.cognome = 'Riva' AND pr.id = ap.progetto
GROUP BY pr.id, pr.nome;


-- 10. Qual è il nome dei progetti su cui lavorano più di due strutturati?

SELECT pr.id,pr.nome AS NomeProgetto
FROM Persona p,Progetto pr, AttivitaProgetto ap
WHERE p.id = ap.persona and ap.progetto = pr.id
GROUP BY pr.id,pr.nome
HAVING COUNT(DISTINCT p.id) > 2;


-- 11. Quali sono i professori associati che hanno lavorato su più di un progetto?

SELECT p.id AS id_persona, p.nome, p.cognome
FROM Persona p, Progetto pr, AttivitaProgetto ap
WHERE p.id = ap.persona AND pr.id = ap.progetto AND p.posizione = 'Professore Associato'
GROUP BY p.id, p.nome, p.cognome
HAVING COUNT(DISTINCT pr.id) > 1;
