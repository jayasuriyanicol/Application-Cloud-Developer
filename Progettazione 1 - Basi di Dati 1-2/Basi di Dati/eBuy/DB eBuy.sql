-- Creazione del DB eBuy

BEGIN TRANSACTION
SET CONSTRAINTS ALL DEFERRED;


CREATE TABLE Categoria (

    nome Stringa PRIMARY KEY,
    super Stringa

    CHECK (nome <> super )

);

ALTER TABLE Categoria 
ADD CONSTRAINTS fk_categoria_super
FOREIGN KEY (super) REFERENCES categoria(nome);



CREATE TABLE Utente(

    username Stringa PRIMARY KEY,
    registrazione TIMESTAMP NOT NULL

);


CREATE TABLE PostOggetto(

    descrizione Stringa NOT NULL,
    pubblicazione TIMESTAMP NOT NULL,
    ha_feedback BOOLEAN,
    voto Voto,
    commento Stringa,
    istante_feedback TIMESTAMP NOT NULL,
    id PRIMARY KEY

    FOREIGN KEY Utente REFERENCES utente(username)
);


CREATE TABLE MetodoPagamento(

    nome Stringa PRIMARY KEY NOT NULL

    FOREIGN KEY (met_post) REFERENCES PostOggetto(id)
);



CREATE TABLE PostOggettoUsato(

    condizione Condizione NOT NULL,
    anni_garanzia IntGEZ NOT NULL


    FOREIGN KEY (poi_isa_po) REFERENCES PostOggetto(id)


);


CREATE TABLE VenditoreProfessionale(

    vetrina Url PRIMARY KEY

    


);


CREATE TABLE PostOggettoNuovo(

    anni_garanzia IntG1 NOT NULL

    FOREIGN KEY (pon_isa_po) REFERENCES PostOggetto(id)


);


CREATE TABLE Privato(


);


CREATE TABLE Asta(

    prezzo_base RealGEZ NOT NULL,
    prezzo_bid RealGZ NOT NULL,
    scadenza TIMESTAMP NOT NULL


);

CREATE TABLE Bid(

    codice SERIAL PRIMARY KEY NOT NULL,
    istante TIMESTAMP NOT NULL

);


CREATE TABLE Acquirente(

    istante TIMESTAMP NOT NULL

);





