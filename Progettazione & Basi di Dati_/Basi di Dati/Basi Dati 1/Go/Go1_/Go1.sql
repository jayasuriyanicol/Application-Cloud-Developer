-- Implentazione guidata di GO 

BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;

--Dichiariamo Domini ed Tipi
CREATE DOMAIN Stirnga AS VARCHAR;  -- Corretto "Stirnga" come da richiesta (presumo voluto)
CREATE DOMAIN IntGZ AS INTEGER CHECK (VALUE > 0);
CREATE DOMAIN regole AS ENUM ('Giapponesi', 'Cinesi');
CREATE TYPE colore AS ENUM ('Bianco', 'Nero');

-- Tipo composito indirizzo
CREATE TYPE indirizzo AS (
    via Stirnga,
    civico Stirnga
);

-- Tabelle
CREATE TABLE nazione (
    nome Stirnga NOT NULL PRIMARY KEY
);

CREATE TABLE regione (
    nome Stirnga NOT NULL,
    nazione Stirnga NOT NULL,
    PRIMARY KEY (nome, nazione),
    FOREIGN KEY (nazione) REFERENCES nazione(nome)
);

CREATE TABLE citta (
    nome Stirnga NOT NULL,
    regione Stirnga NOT NULL,
    nazione Stirnga NOT NULL,
    PRIMARY KEY (nome, regione, nazione),
    FOREIGN KEY (regione, nazione) REFERENCES regione(nome, nazione)
);

-- Eliminata la duplicazione della tabella nazione

CREATE TABLE giocatore (
    nickname Stirnga PRIMARY KEY,
    nome Stirnga NOT NULL,
    cognome Stirnga NOT NULL,
    indirizzo indirizzo NOT NULL,
    rank IntGZ NOT NULL,
    -- Manca chiave per citta, quindi sostituisco con tripla (nome, regione, nazione)
    citta_nome Stirnga NOT NULL,
    citta_regione Stirnga NOT NULL,
    citta_nazione Stirnga NOT NULL,
    FOREIGN KEY (citta_nome, citta_regione, citta_nazione) REFERENCES citta(nome, regione, nazione)
);

CREATE TABLE torneo (
    id INTEGER PRIMARY KEY,
    nome Stirnga NOT NULL,
    descrizione Stirnga NOT NULL,
    anno_edizione INTEGER NOT NULL
);

-- Dato che il riferimento a nero (tabella) è avanti, la dichiarazione di partita va dopo

CREATE TABLE nero (
    giocatore Stirnga NOT NULL,
    partita INTEGER NOT NULL,
    PRIMARY KEY (partita),
    FOREIGN KEY (giocatore) REFERENCES giocatore(nickname),
    FOREIGN KEY (partita) REFERENCES partita(id)
);

-- creo una versione semplificata del dominio per il komi
CREATE DOMAIN Real_0_10 AS REAL CHECK (VALUE >= 0 AND VALUE <= 10);

CREATE TABLE partita (
    id INTEGER PRIMARY KEY,
    date DATE NOT NULL,
    regole regole NOT NULL,
    indirizzo indirizzo NOT NULL,
    komi Real_0_10 NOT NULL,
    bianco Stirnga NOT NULL,
    torneo INTEGER,
    citta_nome Stirnga NOT NULL,
    citta_regione Stirnga NOT NULL,
    citta_nazione Stirnga NOT NULL,

    FOREIGN KEY (bianco) REFERENCES giocatore(nickname),
    FOREIGN KEY (id) REFERENCES nero(partita), -- questo è **semantico**, gestito dopo
    FOREIGN KEY (torneo) REFERENCES torneo(id),
    FOREIGN KEY (citta_nome, citta_regione, citta_nazione) REFERENCES citta(nome, regione, nazione)
);

-- Tabella con punteggi
CREATE TABLE PartitaConPunteggi (
    partita INTEGER PRIMARY KEY,
    punteggio_bianco IntGZ NOT NULL,
    punteggio_nero IntGZ NOT NULL,
    FOREIGN KEY (partita) REFERENCES partita(id)
);

-- Tabella con vincitore per rinuncia
CREATE TABLE PartitaConRinunciatario (
    partita INTEGER PRIMARY KEY,
    rinunciatario colore NOT NULL,
    FOREIGN KEY (partita) REFERENCES partita(id)
);

-- Transazione di esempio (sintassi INSERT corretta)
BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;

-- Esempi dimostrativi (non eseguibili così come sono, mancano valori reali)
-- INSERT INTO giocatore (...) VALUES ('Nicolxxx', ...);
-- INSERT INTO partita (id, bianco, ...) VALUES (1, ...);

COMMIT;