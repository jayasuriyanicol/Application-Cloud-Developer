-- Creazione ACCADEMIA 5


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


begin transaction;

set constraints all deferred;


INSERT INTO Persona(id, nome, cognome, posizione, stipendio)
VALUES
('21',	'Anna',		'Bianchi', 		'Ricercatore', 			'45500.30'),
('1',	'Mario',	'Rossi', 		'Ricercatore', 			'35500.00'),
('2',	'Barbara',	'Burso', 		'Ricercatore', 			'40442.50'),
('3',	'Gino',		'Spada', 		'Ricercatore', 			'35870.90'),
('4',	'Aurora',	'Bianchi', 		'Professore Associato', '43500.50'),
('5',	'Guido',	'Spensierato', 	'Professore Associato', '38221.00'),
('6',	'Consolata','Ferrari',	 	'Professore Associato', '29200.10'),
('7',	'Andrea',	'Verona', 		'Professore Associato', '39002.05'),
('8',	'Asia',		'Giordano', 	'Professore Ordinario', '45200.10'),
('9', 	'Carlo',	'Zante', 		'Professore Ordinario', '40230.00'),
('10', 	'Ginevra',	'Riva', 		'Professore Ordinario', '39955.00'),
('11', 	'Davide',	'Quadro', 		'Professore Ordinario', '36922.10'),
('12', 	'Dario',	'Basile', 		'Ricercatore', 			'42566.00'),
('13', 	'Silvia',	'Donati', 		'Professore Ordinario', '38005.00'),
('14', 	'Fiorella', 'Martino', 		'Professore Associato', '35544.50'),
('15', 	'Leonardo', 'Vitali', 		'Professore Ordinario', '38779.80'),
('16', 	'Paolo',	'Valentini', 	'Professore Associato', '39200.00'),
('17', 	'Emilio',	'Greco', 		'Professore Associato', '42020.00'),
('18', 	'Giulia',	'Costa', 		'Ricercatore', 			'40220.00'),
('19', 	'Elisa',	'Longo', 		'Professore Associato', '39001.00'),
('20', 	'Carla',	'Martinelli', 	'Ricercatore', 			'42030.20');


INSERT INTO Progetto(id, nome, inizio, fine, budget) VALUES
('21',	'Artemide',		'2000-01-01',	'2002-12-31',	'255000'),
('1',	'Pegasus',		'2012-01-01',	'2014-12-31',	'330000'),
('2',	'WineSharing',	'1999-01-01',	'2003-12-31',	'998000'),
('3',	'Simap',		'2010-02-01',	'2014-03-17',	'158000'),
('4',	'DropDiscovery','2010-09-13',	'2013-01-20',	'99000');


INSERT INTO WP(progetto, id, nome, inizio, fine) VALUES
('21',	'21',	'WP1',				'2000-01-01',	'2000-12-31'),
('21',	'1',	'WP2',				'2001-01-01',	'2001-12-31'),
('21',	'2',	'WP3',				'2002-01-01',	'2002-12-31'),
('1',	'21',	'WP1',				'2012-01-01',	'2012-12-31'),
('1',	'1',	'WP2',				'2012-01-01',	'2012-12-31'),
('1',	'2',	'WP3',				'2013-01-01',	'2013-12-31'),
('2',	'1',	'Main Activity',	'1999-01-01',	'2003-12-31'),
('3',	'21',	'State of the Art',	'2012-01-01',	'2012-12-31'),
('3',	'1',	'Main Research',	'2013-01-01',	'2013-12-31'),
('3',	'2',	'Dissemination',	'2014-01-01',	'2014-03-17');


INSERT INTO AttivitaProgetto(id, persona, progetto, wp, giorno, tipo, oreDurata)
VALUES
('21',	'21',	'1',	'21',	'2012-04-15',	'Ricerca e Sviluppo',	'8'),
('1',	'21',	'1',	'21',	'2012-04-16',	'Ricerca e Sviluppo',	'8'),
('2',	'21',	'1',	'21',	'2012-04-17',	'Ricerca e Sviluppo',	'8'),
('3',	'21',	'1',	'21',	'2012-04-18',	'Ricerca e Sviluppo',	'8'),
('4',	'8',	'1',	'2',	'2013-03-15',	'Dimostrazione',		'8'),
('5',	'10',	'1',	'21',	'2012-06-03',	'Ricerca e Sviluppo',	'8'),
('6',	'2',	'1',	'1',	'2012-04-22',	'Dimostrazione',		'7'),
('7',	'4',	'3',	'1',	'2013-01-19',	'Management',			'6'),
('8',	'11',	'3',	'2',	'2014-02-15',	'Altro',				'5'),
('9',	'21',	'3',	'2',	'2014-03-08',	'Ricerca e Sviluppo',	'6'),
('10',	'4',	'2',	'1',	'2000-01-19',	'Management',			'2');

INSERT INTO AttivitaNonProgettuale(id, persona, tipo, giorno, oreDurata) 
VALUES
('21',	'8',	'Incontro Dipartimentale',	'2011-06-01',	'4'),
('1',	'8',	'Didattica',				'2011-03-15',	'8'),
('2',	'8',	'Incontro Dipartimentale',	'2011-06-15',	'4'),
('3',	'2',	'Didattica',				'2014-04-01',	'4'),
('4',	'2',	'Didattica',				'2014-04-03',	'4'),
('5',	'1',	'Didattica',				'2014-04-03',	'8'),
('6',	'4',	'Incontro Accademico',		'2012-11-25',	'7'),
('7',	'7',	'Missione',					'2013-07-07',	'3'),
('8',	'5',	'Missione',                 '2012-12-15',	'6'),
('9',	'21',	'Didattica',				'2012-04-18',	'4'),
('10',	'6',	'Didattica',				'2011-05-07',	'7');


INSERT INTO Assenza(id, persona, tipo, giorno) VALUES
('21',	'10',	'Malattia',				'2011-06-01'),
('1',	'10',	'Malattia',				'2011-06-02'),
('2',	'10',	'Malattia',				'2011-06-03'),
('3',	'10',	'Maternita',			'2011-06-04'),
('4',	'8',	'Malattia',				'2011-07-02'),
('5',	'19',	'Chiusura Universitaria','2013-06-29'),
('6',	'7',	'Malattia',				'2012-12-07'),
('7',	'21',	'Maternita',			'2013-10-27'),
('8',	'17',	'Chiusura Universitaria','2011-08-15'),
('9',	'15',	'Maternita',			'2010-12-12'),
('10',  '21',	'Malattia', 			'2012-04-18');


commit;



-- QUERY

-- 1 | Quali sono il nome, la data di inizio e la data di fine dei WP del progetto di nome  'Pegasus'?

SELECT wp.nome, wp.inizio, wp.fine
FROM WP AS wp, progetto AS pr
WHERE wp.progetto = pr.id AND pr.nome = 'Pegasus';
 

-- 2 | Quali sono il nome, il cognome e la posizione degli strutturati che hanno più di una attività nel progetto 'Pegasus', ordinati per cognome decrescente?

SELECT DISTINCT p.nome, p.cognome, p.posizione

FROM Persona AS p, Progetto pr, AttivitaProgetto ap

WHERE p.id = ap.persona AND ap.progetto = pr.id  AND pr.nome = 'Pegasus'

ORDER BY p.cognome DESC;



-- 3 | Quali sono il nome, il cognome e la posizione degli strutturati che hanno più di una attività nel progetto 'Pegasus'?

SELECT DISTINCT p.nome, p.cognome, p.posizione
FROM Persona AS p, attivitaprogetto AS ap, attivitaprogetto AS ap2, progetto AS pr
WHERE p.id = ap.persona 
AND ap.progetto = pr.id 
AND ap2.id <> ap.id
AND ap2.persona = ap.persona
AND pr.nome = 'Pegasus'
AND ap2.progetto = ap.progetto
ORDER BY p.cognome;


-- 4 | Quali sono il nome, il cognome dei Professori Ordinari che hanno fatto almeno una assenza per malattia?

SELECT DISTINCT p.nome, p.cognome
FROM Persona p, Assenza a 
WHERE p.id = a.persona AND p.posizione = 'Professore Ordinario' AND a.tipo = 'Malattia';



-- 5 | Quali sono il nome, il cognome dei Professori Ordinari che hanno fatto più di una assenza per malattia?

SELECT DISTINCT p.nome, p.cognome
FROM Persona p, Assenza a, Assenza a2
WHERE p.id = a.persona 
AND p.posizione = 'Professore Ordinario' 
AND a2.id <> a.id
AND a2.persona = p.id
AND a.tipo = 'Malattia';



-- 6 | Quali sono il nome, il cognome dei Ricercatori che hanno almeno un impegno per didattica?

SELECT  DISTINCT p.nome, p.cognome
FROM Persona p, AttivitaNonProgettuale anp 
WHERE p.id = anp.persona AND p.posizione = 'Ricercatore' AND anp.tipo = 'Didattica';


-- 7 | Quali sono il nome e il cognome dei Ricercatori che hanno più di un impegno per 'Didattica' ?

SELECT DISTINCT p.nome, p.cognome
FROM Persona p, AttivitaNonProgettuale anp, AttivitaNonProgettuale anp2
WHERE anp.persona = p.id
AND anp2.id <> anp.id 
AND anp.persona = anp2.persona
AND p.posizione = 'Ricercatore'
AND anp.tipo = 'Didattica';


-- 8 | Quali sono il nome e il cognome degli strutturati che nello stesso giorno hanno sia attivita' progettuali che attivita' non progettuali?


SELECT DISTINCT p.nome, p.cognome

FROM Persona p , AttivitaProgetto ap , AttivitaNonProgettuale anp

WHERE ap.persona = p.id
AND anp.persona = p.id
AND ap.giorno = anp.giorno;


-- 9 | Quali sono il nome e il cognome degli strutturati che nello stesso giorno hanno si attivita' progettuali che attivita' non progettuali? Si richiede di restituire anche il giorno, il nome del progetto, il tipo dell'attivita' non progettuale e la durata in ore di entrambe le attivita'

SELECT DISTINCT pe.nome,pe.cognome, ap.giorno, p.nome prj, ap.oreDurata h_prj, anp.tipo att_noprj, anp.oreDurata h_noprj

FROM Persona pe, Progetto p, AttivitaProgetto ap, AttivitaNonProgettuale anp

WHERE pe.id = ap.persona
AND pe.id = anp.persona
AND ap.giorno = anp.giorno
AND p.nome = 'Pegasus';

-- 10 | Quali sono il nome e il cognome degli strutturati che nello stesso giorno sono assenti e hanno attivita' progettuali?


SELECT pe.nome, pe.cognome

FROM Persona pe, AttivitaProgetto ap, Assenza a 

WHERE pe.id = ap.persona
AND pe.id = a.persona
AND ap.giorno = a.giorno;