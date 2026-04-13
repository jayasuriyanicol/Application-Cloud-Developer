-- Definition of the banca_db schema DML for PostgreSQL, used to do it with my own not using AI. Using it for testing part.

-- Inserimento Indirizzi
INSERT INTO indirizzo (id_indirizzo, via, cap, citta, provincia) VALUES 
(1, 'Via Roma 87, INT 4', '00100', 'ROMA', 'RM'),
(2, 'Via Frassina 23, INT 3', '00189', 'TIVOLI', 'RM'),
(3, 'Via Posilippo 3, INT 1', '00192', 'FIUMICINO', 'RM');

-- Inserimento Utenti
INSERT INTO utente (id_utente, nome, cognome, mail, telefono, id_indirizzo) VALUES 
(1, 'Mario', 'Rossi', 'mario@rossi.it', '+39 3644782697', 1),
(2, 'Francesco', 'Bianchi', 'bianchifra45@gmail.com', '+39 3977512102', 2),
(3, 'Cristiano', 'Coccia', 'coccia.cris03@gmail.com', '+39 3210159786', 3);

-- Aggiornamento delle sequenze (Indispensabile in Postgres dopo INSERT manuali con ID)
SELECT setval('indirizzo_id_indirizzo_seq', (SELECT MAX(id_indirizzo) FROM indirizzo));
SELECT setval('utente_id_utente_seq', (SELECT MAX(id_utente) FROM utente));

