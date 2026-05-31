CREATE VoliAerei1;
\c VoliAerei1

BEGIN transaction;

SET CONSTRAINT ALL deffer;

CREATE DOMAIN Stringa AS VARCHAR;

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


    FOREIGN KEY (citta) REFERENCES citta(id)

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


commit;



begin transaction;
INSERT INTO Nazione (id, nome) VALUES
(1, 'Italia'),
(2, 'Francia'),
(3, 'Germania'),
(4, 'Spagna'),
(5, 'Stati Uniti'),
(6, 'Regno Unito'),
(7, 'Giappone');

INSERT INTO Citta (id, nome, n_abitanti, nazione) VALUES
(1, 'Roma', 2800000, 1),
(2, 'Milano', 1400000, 1),
(3, 'Parigi', 2140000, 2),
(4, 'Berlino', 3700000, 3),
(5, 'Madrid', 3300000, 4),
(6, 'Barcellona', 1600000, 4),
(7, 'New York', 8400000, 5),
(8, 'Los Angeles', 4000000, 5),
(9, 'Londra', 8900000, 6),
(10, 'Tokyo', 14000000, 7),
(11, 'Firenze', 380000, 1),
(12, 'Napoli', 970000, 1),
(13, 'Lione', 510000, 2),
(14, 'Monaco', 1470000, 3),
(15, 'Siviglia', 690000, 4);

INSERT INTO Aereoporto (id, codice, nome, citta) VALUES
(1, 'FCO', 'Fiumicino', 1),
(2, 'LIN', 'Linate', 2),
(3, 'CDG', 'Charles de Gaulle', 3),
(4, 'TXL', 'Tegel', 4),
(5, 'MAD', 'Barajas', 5),
(6, 'JFK', 'John F. Kennedy', 7),
(7, 'LHR', 'Heathrow', 9),
(8, 'LAX', 'Los Angeles Int.', 8),
(9, 'NRT', 'Narita', 10),
(10, 'CIA', 'Ciampino', 1),
(11, 'BCN', 'El Prat', 6),
(12, 'FLR', 'Amerigo Vespucci', 11),
(13, 'NAP', 'Capodichino', 12),
(14, 'LYS', 'Saint-Exupéry', 13),
(15, 'MUC', 'Franz Josef Strauss', 14);

INSERT INTO CompagniaAerea (id, nome, fondazione, citta) VALUES
(1, 'Alitalia', 1946, 1),
(2, 'Air France', 1933, 3),
(3, 'Lufthansa', 1953, 4),
(4, 'Iberia', 1927, 5),
(5, 'British Airways', 1974, 9),
(6, 'American Airlines', 1926, 7),
(7, 'Ryanair', 1984, 1),
(8, 'Emirates', 1985, 9);

INSERT INTO Volo (id, codice, durata_in_minuti, compagnia, arrivo, partenza) VALUES
(1, 'AZ123', 90, 1, 2, 1),
(2, 'AF456', 120, 2, 1, 3),
(3, 'LH789', 150, 3, 5, 4),
(4, 'IB101', 180, 4, 7, 5),
(5, 'BA202', 240, 5, 8, 7),
(6, 'AA303', 300, 6, 9, 8),
(7, 'FR404', 100, 7, 10, 1),
(8, 'EK505', 360, 8, 1, 7),
(9, 'AZ102', 75, 1, 12, 1),
(10, 'AF678', 110, 2, 14, 3),
(11, 'LH901', 160, 3, 15, 4),
(12, 'IB202', 95, 4, 11, 5),
(13, 'BA303', 250, 5, 13, 7),
(14, 'AA404', 310, 6, 1, 8),
(15, 'FR505', 85, 7, 13, 10),
(16, 'EK606', 380, 8, 3, 9),
(17, 'AZ103', 130, 1, 11, 12),
(18, 'AF789', 140, 2, 15, 14),
(19, 'LH910', 190, 3, 11, 15),
(20, 'IB303', 105, 4, 1, 11);
commit;