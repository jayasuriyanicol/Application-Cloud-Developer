-- Creazione del DB eBuy

BEGIN TRANSACTION
SET CONSTRAINTS ALL DEFERRED;


CREATE TABLE Categoria (

    nome Stringa PRIMARY KEY,
    super Stringa,

    CHECK (nome <> super )

);


ALTER TABLE Categoria 
ADD CONSTRAINT fk_categoria_super
FOREIGN KEY (super) REFERENCES categoria(nome);



CREATE TABLE Utente(

    username Stringa PRIMARY KEY,
    registrazione TIMESTAMP NOT NULL,

    --Per utilizzare la funzione 'Disjoint & Complete' possiamo utilizzare questo CHECK
    --dato che in PostgreSQL non vi è un'opzione specifica ma ELEMENTARMENTE possiamo utilizzare
    --solo dei CHECK per ovviare a questa situazione.
    tipologiaUtente VARCHAR NOT NULL,
   
    CHECK(tipologiaUtente IN ('Privato', 'Venditore'))

);



CREATE TABLE VenditoreProfessionale(

    vetrina Url UNIQUE NOT NULL,

    utente Stringa PRIMARY KEY,

    FOREIGN KEY (utente) REFERENCES Utente(username) DEFERRABLE


);
-- Vincoli {disjoint, complete} su Utente non ancora completati

CREATE TABLE Privato(

    utente Stringa PRIMARY KEY,

    FOREIGN KEY (utente) REFERENCES Utente(username) DEFERRABLE

);



CREATE TABLE MetodoPagamento(

    nome Stringa PRIMARY KEY NOT NULL

);



CREATE TABLE PostOggetto(
    
    id SERIAL PRIMARY KEY,
    descrizione Stringa NOT NULL,
    pubblicazione TIMESTAMP NOT NULL,
    ha_feedback BOOLEAN DEFAULT false,
    voto Voto,
    commento Stringa,
    istante_feedback TIMESTAMP NOT NULL,

    pubblica Stringa NOT NULL,
    categoria Stringa NOT NULL,

  --CHIAVE NON MINIMALE:Utilizziamo questa forma facoltativa, perchè la FOREIGN KEY deve puntare da qualche parte
  --garantendo così la coerenza di dati, così da ovviare ad errori.
    UNIQUE(id,pubblica) 
    

    FOREIGN KEY (pubblica) REFERENCES Utente(username),
    FOREIGN KEY (Categoria) REFERENCES Categoria(nome),

    
  --CHECK superfluo, non necessario per il sistema, ma possibile utilizzarlo come metodo di ENNUPLA
    CHECK (istante_feedback IS NULL OR istante_feedback > pubblicazione)

    CHECK((ha_feedback = True) =  (voto IS NOT NULL AND istante_feedback IS NOT NULL))
    
  --Utilizziamo la funzione A -> (implica) B  ==  (NOT A) OR B
    CHECK((commento IS NOT NULL or ha_feedback = True))
);


CREATE TABLE met_post (

    metodo Stringa NOT NULL,
    postOggetto INTEGER NOT NULL,

    PRIMARY KEY (metodo,postOggetto),

    FOREIGN KEY (metodo) REFERENCES MetodoPagamento(nome),
    FOREIGN KEY (postOggetto) REFERENCES PostOggetto(id)

    --Il vinc. inclus. (id) occorre in met_post(postoggetto)

);


CREATE TABLE PostOggettoUsato(

    condizione Condizione NOT NULL,
    anni_garanzia IntGEZ NOT NULL,

    postoggetto INTEGER PRIMARY KEY,
    FOREIGN KEY (postoggetto) REFERENCES PostOggetto(id) DEFERRABLE

);


CREATE TABLE PostOggettoNuovo(

    anni_garanzia IntG2 NOT NULL,

    postoggetto INTEGER PRIMARY KEY,
    pubblica_nuovo Stringa NOT NULL,

    FOREIGN KEY (postoggetto) REFERENCES PostOggetto(id) DEFFERABLE,
    FOREIGN KEY(pubblica_nuovo) REFERENCES VenditoreProfessionale(utante) DEFFERABLE,
    FOREIGN KEY (postoggetto, pubblica_nuovo) REFERENCES postoggetto(id,pubblica) DEFERRABLE
);

-- Vincoli {disjoint, complete} su PostOggetto nuovo/usato non ancora implementati

CREATE TABLE PostOggettoCompraloSubito(

    postoggetto INTEGER PRIMARY KEY,
    prezzo RealGZ NOT NULL,
    acquirente Stringa,


    acquirente Stringa,
    istante_acquisto TIMESTAMP,

    FOREIGN KEY (acquirente) REFERENCES privato(utente)
    FOREIGN KEY(postoggetto) REFERENCES postoggetto(id)
    

    CHECK((acquirente INTEGER IS NULL) = (istante_acquisto IS NULL))
);


CREATE TABLE PostOggettoAsta(
    
    postoggetto INTEGER PRIMARY KEY,

    prezzo_base RealGEZ NOT NULL,
    prezzo_bid RealGZ NOT NULL,
    scadenza TIMESTAMP NOT NULL,

    FOREIGN KEY(postoggetto) REFERENCES Postoggetto(id) DEFERRABLE
);




CREATE TABLE Bid(

    codice SERIAL PRIMARY KEY,
    istante TIMESTAMP NOT NULL,


    
    asta_bid INTEGER NOT NULL,

    UNIQUE(istante,asta_bid),

    bid_ut Stringa NOT NULL,

    FOREIGN KEY(asta_bid) REFERENCES Asta(asta_isa_po),
    FOREIGN KEY(bid_ut) REFERENCES Privato(pr_isa_ut)

);


COMMIT;