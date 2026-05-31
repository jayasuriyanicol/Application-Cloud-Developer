BEGIN TRANSACTION;
SET CONSTRAINTS ALL DEFERRED;

CREATE TABLE Nazione (
    nome Stringa PRIMARY KEY
);


CREATE TABLE Regione(
 
    nome Stringa,
    nazione Stringa,

FOREIGN KEY (nazione) REFERENCES Nazione(nome),
PRIMARY KEY (nome,nazione)

);


CREATE TABLE Citta (

    nome Stringa,
    regione Stringa,
    nazione Stringa,

FOREIGN KEY (regione,nazione) REFERENCES Regione(nome,nazione),
PRIMARY KEY (nome,regione,nazione)
);


CREATE TABLE Direttore (

    nome Stringa NOT NULL,
    cognome Stringa NOT NULL,
    cf CodiceFiscale PRIMARY KEY,
    data_nascita DATE NOT NULL,
    anni_servizio IntGEZ NOT NULL,

    citta_nasc Stringa NOT NULL,
    regione_nasc Stringa NOT NULL,
    nazione_nasc Stringa NOT NULL,
    
FOREIGN KEY (citta_nasc, regione_nasc, nazione_nasc) REFERENCES Citta(nome, regione, nazione)

);



CREATE TABLE Dipartimento (

    nome Stringa PRIMARY KEY,
    indirizzo Indirizzo NOT NULL,
    direttore CodiceFiscale NOT NULL,

FOREIGN KEY (direttore) REFERENCES Direttore(cf)

);


CREATE TABLE Fornitore (

    ragione_sociale Stringa NOT NULL,
    partita_iva PartitaIva PRIMARY KEY,
    indirizzo Indirizzo NOT NULL,
    telefono Telefono NOT NULL,
    email Email NOT NULL

);



CREATE TABLE Ordine (

    id INTEGER PRIMARY KEY,
    data_stipula DATE NOT NULL,
    imponibile RealGEZ NOT NULL,
    aliquotaIVA Real0_1 NOT NULL,
    descrizione Stringa NOT NULL,
    stato Stato NOT NULL,
    fornitore PartitaIva NOT NULL,
    dipartimento Stringa NOT NULL,

FOREIGN KEY (fornitore) REFERENCES fornitore(partita_iva),
FOREIGN KEY (dipartimento) REFERENCES Dipartimento(nome)

);

COMMIT;