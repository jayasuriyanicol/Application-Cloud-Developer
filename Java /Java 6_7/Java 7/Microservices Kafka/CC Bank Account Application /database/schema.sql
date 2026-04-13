-- Definition of the banca_db schema DDL for PostgreSQL, despite the fact it will be do it by Hibernate. Using it for testing part.


-- 1. Creazione Tabella Indirizzo
CREATE TABLE indirizzo (
    id_indirizzo SERIAL PRIMARY KEY,
    via VARCHAR(255) NOT NULL,
    cap VARCHAR(10) NOT NULL,
    citta VARCHAR(100) NOT NULL,
    provincia VARCHAR(50) NOT NULL
);

-- 2. Creazione Tabella Utente
CREATE TABLE utente (
    id_utente SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    mail VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    id_indirizzo INTEGER NOT NULL,
    CONSTRAINT fk_indirizzo FOREIGN KEY (id_indirizzo) REFERENCES indirizzo(id_indirizzo) ON DELETE CASCADE
);

-- 3. Creazione Tabella Conto Corrente
CREATE TABLE conto_corrente (
    numero_conto SERIAL PRIMARY KEY,
    saldo DOUBLE PRECISION DEFAULT 0.0,
    data_apertura TIMESTAMP NOT NULL,
    intestatario_id_utente INTEGER NOT NULL,
    cointestatario_id_utente INTEGER,
    CONSTRAINT fk_intestatario FOREIGN KEY (intestatario_id_utente) REFERENCES utente(id_utente),
    CONSTRAINT fk_cointestatario FOREIGN KEY (cointestatario_id_utente) REFERENCES utente(id_utente)
);

-- 4. Creazione Tabella Movimento
CREATE TABLE movimento (
    id_movimento SERIAL PRIMARY KEY,
    data_movimento TIMESTAMP NOT NULL,
    importo DOUBLE PRECISION NOT NULL,
    operazione VARCHAR(20) CHECK (operazione IN ('versamento', 'prelievo')),
    conto_associato_numero_conto INTEGER NOT NULL,
    operatore_banca_id_utente INTEGER NOT NULL,
    CONSTRAINT fk_conto FOREIGN KEY (conto_associato_numero_conto) REFERENCES conto_corrente(numero_conto) ON DELETE CASCADE,
    CONSTRAINT fk_operatore FOREIGN KEY (operatore_banca_id_utente) REFERENCES utente(id_utente)
);